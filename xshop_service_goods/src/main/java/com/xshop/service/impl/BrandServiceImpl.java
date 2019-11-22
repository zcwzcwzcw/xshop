package com.xshop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xshop.dao.BrandMapper;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Brand;
import com.xshop.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 品牌服务实现类
 * @author zcw
 * @date 2019/11/9
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        return new PageResult<Brand>(brandPageInfo.getTotal(), brandPageInfo.getList());
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = searchExample(searchMap, Arrays.asList("name", "letter"), Brand.class);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        List<Brand> list = findList(searchMap);
        PageInfo pageInfo = new PageInfo(list);
        return new PageResult<Brand>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    @SuppressWarnings("all")
    public CommonResponse<Brand> save(Brand brand) {
        int r = brandMapper.insert(brand);
        return r > 0 ? CommonResponse.success("添加成功") : CommonResponse.error("添加失败");
    }

    @Override
    @SuppressWarnings("all")
    public CommonResponse<Brand> update(Brand brand) {
        int r = brandMapper.updateByPrimaryKeySelective(brand);
        return r > 0 ? CommonResponse.success("更新成功") : CommonResponse.error("更新失败");
    }

    @Override
    @SuppressWarnings("all")
    public CommonResponse<Brand> delete(Integer id) {
        int r = brandMapper.deleteByPrimaryKey(id);
        return r > 0? CommonResponse.success("删除成功") : CommonResponse.error("删除失败");
    }

    /**
     * 根据查询条件和字段，获取example对象
     */
    private Example searchExample(Map<String, Object> searchMap, List<String> properties, Class clazz) {
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        if (!CollectionUtils.isEmpty(searchMap) && !CollectionUtils.isEmpty(properties)) {
            properties.forEach(p -> {
                if (searchMap.get(p) != null) {
                    criteria.andEqualTo(p, searchMap.get(p));
                }
            });
        }
        return example;
    }

}
