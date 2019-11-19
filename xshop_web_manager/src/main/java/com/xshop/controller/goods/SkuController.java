package com.xshop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Sku;
import com.xshop.service.goods.SkuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/sku")
public class SkuController {

    @Reference
    private SkuService skuService;

    @GetMapping("/findAll")
    public List<Sku> findAll(){
        return skuService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Sku> findPage(int page, int size){
        return skuService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Sku> findList(@RequestBody Map<String,Object> searchMap){
        return skuService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Sku> findPage(@RequestBody Map<String,Object> searchMap, int page, int size){
        return  skuService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Sku findById(String id){
        return skuService.findById(id);
    }


    @PostMapping("/add")
    public CommonResponse add(@RequestBody Sku sku){
        skuService.add(sku);
        return CommonResponse.success();
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody Sku sku){
        skuService.update(sku);
        return CommonResponse.success();
    }

    @GetMapping("/delete")
    public CommonResponse delete(String id){
        skuService.delete(id);
        return CommonResponse.success();
    }

}
