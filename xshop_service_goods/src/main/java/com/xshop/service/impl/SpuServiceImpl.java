package com.xshop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xshop.dao.SpuMapper;
import com.xshop.entity.BusinessException;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.*;
import com.xshop.service.goods.CategoryBrandService;
import com.xshop.service.goods.CategoryService;
import com.xshop.service.goods.SkuService;
import com.xshop.service.goods.SpuService;
import com.xshop.util.IdWork;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private IdWork idWork;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SkuService skuService;
    @Autowired
    private CategoryBrandService categoryBrandService;


    @Override
    public List<Spu> findAll() {
        return spuMapper.selectAll();
    }

    @Override
    public PageResult<Spu> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Spu> spus = (Page<Spu>) spuMapper.selectAll();
        return new PageResult<Spu>(spus.getTotal(), spus.getResult());
    }

    @Override
    public List<Spu> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return spuMapper.selectByExample(example);
    }

    @Override
    public PageResult<Spu> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<Spu> spus = (Page<Spu>) spuMapper.selectByExample(example);
        return new PageResult<Spu>(spus.getTotal(), spus.getResult());
    }

    @Override
    public Spu findById(String id) {
        return spuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Spu spu) {
        spuMapper.insert(spu);
    }

    @Override
    public void update(Spu spu) {
        spuMapper.updateByPrimaryKeySelective(spu);
    }

    @Override
    public void delete(String id) {
        spuMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveGoods(GoodsDTO goodsDTO) {
        Spu spu = goodsDTO.getSpu();
        // 如果spuId存在则新增，否则修改
        if (StringUtils.isEmpty(spu.getId())) {
            spu.setId(idWork.nextId().toString());
            spuMapper.insert(spu);
        } else {
            skuService.deleteBySpuId(spu.getId());
            spuMapper.updateByPrimaryKeySelective(spu);
        }

        Date date = new Date();
        Category category = categoryService.findById(spu.getCategory3Id());
        if (category == null) {
            throw new BusinessException("分类不存在，id=" + spu.getCategory3Id());
        }

        List<Sku> skuList = goodsDTO.getSkuList();
        skuList.forEach(sku -> {
            // 不启用规格
            if (StringUtils.isBlank(sku.getSpec())) {
                sku.setSpec("{}");
            }
            StringBuilder skuName = new StringBuilder(sku.getName());
            Map specMap = JSON.parseObject(sku.getSpec(), Map.class);
            specMap.values().forEach(v -> {
                skuName.append(" ").append(v);
            });

            if (StringUtils.isEmpty(sku.getId())) {
                sku.setId(idWork.nextId().toString());
                sku.setCreateTime(date);
            }
            sku.setName(skuName.toString());
            sku.setSpuId(spu.getId());
            sku.setCategoryId(category.getId());
            sku.setCategoryName(category.getName());
            sku.setUpdateTime(date);
            sku.setCommentNum(0);
            sku.setSaleNum(0);
            skuService.add(sku);
        });
        // 保存分类和品牌的关系
        CategoryBrand categoryBrand = new CategoryBrand(spu.getCategory3Id(), spu.getBrandId());
        categoryBrandService.save(categoryBrand);
    }

    @Override
    public GoodsDTO findGoodsBySpuId(String spuId) {
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        List<Sku> skuList = skuService.findBySpuId(spuId);
        return new GoodsDTO(spu, skuList);
    }

    @Override
    public void audit(String spuId, String status, String message) {
        // TODO 状态值使用枚举
        Spu spu = new Spu();
        spu.setId(spuId);
        spu.setStatus(status);
        if ("1".equals(status)) {
            spu.setIsMarketable("1");
        }
        spuMapper.updateByPrimaryKeySelective(spu);
        // TODO 商品审核记录&商品操作日志
    }

    @Override
    public void pull(String spuId) {
        Spu spu = new Spu();
        spu.setId(spuId);
        spu.setIsMarketable("0");
        spuMapper.updateByPrimaryKeySelective(spu);

        // TODO 商品操作日志
    }

    @Override
    public void put(String spuId) {
        Spu spu = spuMapper.selectByPrimaryKey(spuId);
        if (!"1".equals(spu.getStatus())) {
            throw new BusinessException("商品未审核，不可上架");
        }
        spu.setIsMarketable("1");
        spuMapper.updateByPrimaryKeySelective(spu);
        // TODO 商品操作日志
    }

    @Override
    public int putMany(List<String> spuIds) {
        Spu spu = new Spu();
        spu.setIsMarketable("1");
        // 构建查询条件
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", spuIds);
        criteria.andEqualTo("isMarketable", "0");
        criteria.andEqualTo("status", "1");
        int count = spuMapper.updateByExample(spu, example);
        // TODO 商品日志
        return count;
    }

    /**
     * 构建查询条件
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 货号
            if (searchMap.get("sn") != null && !"".equals(searchMap.get("sn"))) {
                criteria.andLike("sn", "%" + searchMap.get("sn") + "%");
            }
            // SPU名
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            // 副标题
            if (searchMap.get("caption") != null && !"".equals(searchMap.get("caption"))) {
                criteria.andLike("caption", "%" + searchMap.get("caption") + "%");
            }
            // 是否上架
            if (searchMap.get("isMarketable") != null && !"".equals(searchMap.get("isMarketable"))) {
                criteria.andLike("isMarketable", "%" + searchMap.get("isMarketable") + "%");
            }
            // 是否启用规格
            if (searchMap.get("isEnableSpec") != null && !"".equals(searchMap.get("isEnableSpec"))) {
                criteria.andLike("isEnableSpec", "%" + searchMap.get("isEnableSpec") + "%");
            }
            // 是否删除
            if (searchMap.get("isDelete") != null && !"".equals(searchMap.get("isDelete"))) {
                criteria.andLike("isDelete", "%" + searchMap.get("isDelete") + "%");
            }
            // 审核状态
            if (searchMap.get("status") != null && !"".equals(searchMap.get("status"))) {
                criteria.andLike("status", "%" + searchMap.get("status") + "%");
            }

            // 品牌ID
            if (searchMap.get("brandId") != null) {
                criteria.andEqualTo("brandId", searchMap.get("brandId"));
            }
            // 一级分类
            if (searchMap.get("category1Id") != null) {
                criteria.andEqualTo("category1Id", searchMap.get("category1Id"));
            }
            // 二级分类
            if (searchMap.get("category2Id") != null) {
                criteria.andEqualTo("category2Id", searchMap.get("category2Id"));
            }
            // 三级分类
            if (searchMap.get("category3Id") != null) {
                criteria.andEqualTo("category3Id", searchMap.get("category3Id"));
            }
            // 模板ID
            if (searchMap.get("templateId") != null) {
                criteria.andEqualTo("templateId", searchMap.get("templateId"));
            }
            // 运费模板id
            if (searchMap.get("freightId") != null) {
                criteria.andEqualTo("freightId", searchMap.get("freightId"));
            }
        }
        return example;
    }

}
