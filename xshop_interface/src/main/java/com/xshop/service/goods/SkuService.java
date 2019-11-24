package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Sku;

import java.util.List;
import java.util.Map;

/**
 * sku业务逻辑层
 */
public interface SkuService {

    /**
     * 返回全部记录
     */
    List<Sku> findAll();

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Sku> findPage(int page, int size);

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     */
    List<Sku> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Sku> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Sku findById(String id);

    /**
     * 根据spuId查询
     */
    List<Sku> findBySpuId(String spuId);

    /**
     * 新增
     */
    void add(Sku sku);

    /**
     * 修改
     */
    void update(Sku sku);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 根据spuId删除
     */
    void deleteBySpuId(String spuId);

}
