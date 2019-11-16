package com.xshop.service.goods;

import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Album;

import java.util.List;
import java.util.Map;

/**
 * album业务逻辑层
 */
public interface AlbumService {


    public List<Album> findAll();


    public PageResult<Album> findPage(int page, int size);


    public List<Album> findList(Map<String, Object> searchMap);


    public PageResult<Album> findPage(Map<String, Object> searchMap, int page, int size);


    public Album findById(Long id);

    public void add(Album album);


    public void update(Album album);


    public void delete(Long id);

    /**
     * 添加图片
     */
    void addImage(Integer id, String image);
}
