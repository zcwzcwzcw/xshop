package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Pref;

import java.util.List;
import java.util.Map;

/**
 * pref业务逻辑层
 */
public interface PrefService {

    /**
     * 返回全部记录
     */
    List<Pref> findAll();

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Pref> findPage(int page, int size);

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     */
    List<Pref> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Pref> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Pref findById(Integer id);

    /**
     * 新增
     */
    void add(Pref pref);

    /**
     * 修改
     */
    void update(Pref pref);

    /**
     * 删除
     */
    void delete(Integer id);

}
