package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Category;

import java.util.List;
import java.util.Map;

/**
 * category业务逻辑层
 */
public interface CategoryService {

    /**
     * 返回全部记录
     */
    List<Category> findAll();

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Category> findPage(int page, int size);

    /**
     * 条件查询
     * @param searchMap 查询条件
     */
    List<Category> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Category> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Category findById(Integer id);

    /**
     * 新增
     */
    void add(Category category);

    /**
     * 修改
     */
    void update(Category category);

    /**
     *  删除
     */
    void delete(Integer id);

}
