package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Template;

import java.util.List;
import java.util.Map;

/**
 * template业务逻辑层
 */
public interface TemplateService {

    /**
     * 返回全部记录
     */
    List<Template> findAll();

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Template> findPage(int page, int size);

    /**
     * 条件查询
     * @param searchMap 查询条件
     */
    List<Template> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Template> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Template findById(Integer id);

    /**
     * 新增
     */
    void add(Template template);

    /**
     * 修改
     */
    void update(Template template);

    /**
     *  删除
     */
    void delete(Integer id);

}
