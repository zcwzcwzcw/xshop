package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Para;

import java.util.List;
import java.util.Map;

/**
 * para业务逻辑层
 */
public interface ParaService {

    /**
     * 返回全部记录
     */
    List<Para> findAll();

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Para> findPage(int page, int size);

    /**
     * 条件查询
     * @param searchMap 查询条件
     */
    List<Para> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Para> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Para findById(Integer id);

    /**
     * 新增
     */
    void add(Para para);

    /**
     * 修改
     */
    void update(Para para);

    /**
     *  删除
     */
    void delete(Integer id);

}
