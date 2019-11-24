package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Album;

import java.util.List;
import java.util.Map;

/**
 * album业务逻辑层
 */
public interface AlbumService {

    /**
     * 返回全部记录
     */
    List<Album> findAll();

    /**
     * 分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    PageResult<Album> findPage(int page, int size);

    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     */
    List<Album> findList(Map<String, Object> searchMap);

    /**
     * 分页+条件查询
     */
    PageResult<Album> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据Id查询
     */
    Album findById(Long id);

    /**
     * 新增
     */
    void add(Album album);

    /**
     * 修改
     */
    void update(Album album);

    /**
     * 删除
     */
    void delete(Long id);

    /**
     * 添加图片
     */
    void addImage(Integer id, String image);

}
