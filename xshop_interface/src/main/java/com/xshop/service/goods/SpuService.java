package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.GoodsDTO;
import com.xshop.pojo.goods.Spu;

import java.util.List;
import java.util.Map;

/**
 * spu业务逻辑层
 */
public interface SpuService {

    /**
     * 返回全部记录
     */
    List<Spu> findAll();

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Spu> findPage(int page, int size);

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     */
    List<Spu> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Spu> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Spu findById(String id);

    /**
     * 新增
     */
    void add(Spu spu);

    /**
     * 修改
     */
    void update(Spu spu);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 保存或修改商品
     * 根据spuId和skuId判断是保存还是修改
     */
    void saveGoods(GoodsDTO goodsDTO);

    /**
     * 根据spuId查询商品
     */
    GoodsDTO findGoodsBySpuId(String spuId);

    /**
     * 审核商品
     */
    void audit(String spuId, String status, String message);

    /**
     * 商品下架
     */
    void pull(String spuId);

    /**
     * 商品上架
     */
    void put(String spuId);

    /**
     * 商品批量上架
     */
    int putMany(List<String> spuIds);
}
