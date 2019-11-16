package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Category;

import java.util.List;
import java.util.Map;

/**
 * category业务逻辑层
 */
public interface CategoryService {


    public List<Category> findAll();


    public PageResult<Category> findPage(int page, int size);


    public List<Category> findList(Map<String, Object> searchMap);


    public PageResult<Category> findPage(Map<String, Object> searchMap, int page, int size);


    public Category findById(Integer id);

    public void add(Category category);


    public void update(Category category);


    public void delete(Integer id);

}
