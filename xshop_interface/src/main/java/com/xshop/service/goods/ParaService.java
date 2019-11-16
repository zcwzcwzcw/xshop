package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Para;

import java.util.List;
import java.util.Map;

/**
 * para业务逻辑层
 */
public interface ParaService {


    public List<Para> findAll();


    public PageResult<Para> findPage(int page, int size);


    public List<Para> findList(Map<String, Object> searchMap);


    public PageResult<Para> findPage(Map<String, Object> searchMap, int page, int size);


    public Para findById(Integer id);

    public void add(Para para);


    public void update(Para para);


    public void delete(Integer id);

}
