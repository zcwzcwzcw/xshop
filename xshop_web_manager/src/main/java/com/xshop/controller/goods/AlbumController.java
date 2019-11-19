package com.xshop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Album;
import com.xshop.service.goods.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/album")
public class AlbumController {

    @Reference
    private AlbumService albumService;

    @GetMapping("/findAll")
    public List<Album> findAll(){
        return albumService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Album> findPage(int page, int size){
        return albumService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Album> findList(@RequestBody Map<String,Object> searchMap){
        return albumService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Album> findPage(@RequestBody Map<String,Object> searchMap, int page, int size){
        return  albumService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Album findById(Long id){
        return albumService.findById(id);
    }


    @PostMapping("/add")
    public CommonResponse add(@RequestBody Album album){
        albumService.add(album);
        return CommonResponse.success();
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody Album album){
        albumService.update(album);
        return CommonResponse.success();
    }

    @GetMapping("/delete")
    public CommonResponse delete(Long id){
        albumService.delete(id);
        return CommonResponse.success();
    }

    /**
     * 添加图片
     */
    @PostMapping("/addImage")
    public CommonResponse addImage(@RequestParam("id") Integer id, @RequestParam("imageUrl") String imageUrl) {
        albumService.addImage(id, imageUrl);
        return CommonResponse.success();
    }
}
