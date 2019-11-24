package com.xshop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;

import com.xshop.pojo.goods.Pref;
import com.xshop.service.goods.PrefService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/pref")
public class PrefController {

    @Reference
    private PrefService prefService;

    @GetMapping("/findAll")
    public List<Pref> findAll() {
        return prefService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Pref> findPage(int page, int size) {
        return prefService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Pref> findList(@RequestBody Map<String, Object> searchMap) {
        return prefService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Pref> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return prefService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Pref findById(Integer id) {
        return prefService.findById(id);
    }


    @PostMapping("/add")
    public CommonResponse add(@RequestBody Pref pref) {
        prefService.add(pref);
        return CommonResponse.success();
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody Pref pref) {
        prefService.update(pref);
        return CommonResponse.success();
    }

    @GetMapping("/delete")
    public CommonResponse delete(Integer id) {
        prefService.delete(id);
        return CommonResponse.success();
    }

}
