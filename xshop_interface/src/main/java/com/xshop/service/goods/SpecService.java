package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Spec;

import java.util.List;
import java.util.Map;

/**
 * spec业务逻辑层
 */
public interface SpecService {

    /**
     * 返回全部记录
     */
    List<Spec> findAll();

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Spec> findPage(int page, int size);

    /**
     * 条件查询
     * @param searchMap 查询条件
     */
    List<Spec> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Spec> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Spec findById(Integer id);

    /**
     * 新增
     */
    void add(Spec spec);

    /**
     * 修改
     */
    void update(Spec spec);

    /**
     *  删除
     */
    void delete(Integer id);

}
