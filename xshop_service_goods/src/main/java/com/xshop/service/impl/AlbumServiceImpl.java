package com.xshop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xshop.dao.AlbumMapper;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Album;
import com.xshop.service.goods.AlbumService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<Album> findAll() {
        return albumMapper.selectAll();
    }

    @Override
    public PageResult<Album> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Album> albums = (Page<Album>) albumMapper.selectAll();
        return new PageResult<Album>(albums.getTotal(), albums.getResult());
    }

    @Override
    public List<Album> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return albumMapper.selectByExample(example);
    }

    @Override
    public PageResult<Album> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<Album> albums = (Page<Album>) albumMapper.selectByExample(example);
        return new PageResult<Album>(albums.getTotal(), albums.getResult());
    }

    @Override
    public Album findById(Long id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Album album) {
        albumMapper.insert(album);
    }

    @Override
    public void update(Album album) {
        albumMapper.updateByPrimaryKeySelective(album);
    }

    @Override
    public void delete(Long id) {
        albumMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addImage(Integer id, String image) {
        if (id == null || StringUtils.isBlank(image)) {
            throw new RuntimeException("参数错误");
        }
        Album album = albumMapper.selectByPrimaryKey(id);
        if (album != null) {
            JSONArray images = JSONObject.parseArray(album.getImageItems());
            images.add(image);
            album.setImageItems(images.toJSONString());
            int count = albumMapper.updateByPrimaryKey(album);
            if (count <= 0) {
                throw new RuntimeException("添加图片失败");
            }
        }
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 相册名称
            if (searchMap.get("title") != null && !"".equals(searchMap.get("title"))) {
                criteria.andLike("title", "%" + searchMap.get("title") + "%");
            }
            // 相册封面
            if (searchMap.get("image") != null && !"".equals(searchMap.get("image"))) {
                criteria.andLike("image", "%" + searchMap.get("image") + "%");
            }
            // 图片列表
            if (searchMap.get("imageItems") != null && !"".equals(searchMap.get("imageItems"))) {
                criteria.andLike("imageItems", "%" + searchMap.get("imageItems") + "%");
            }


        }
        return example;
    }

}
