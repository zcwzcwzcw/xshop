package com.xshop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Para;
import com.xshop.service.goods.ParaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/para")
public class ParaController {

    @Reference
    private ParaService paraService;

    @GetMapping("/findAll")
    public List<Para> findAll() {
        return paraService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Para> findPage(int page, int size) {
        return paraService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Para> findList(@RequestBody Map<String, Object> searchMap) {
        return paraService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Para> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return paraService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Para findById(Integer id) {
        return paraService.findById(id);
    }


    @PostMapping("/add")
    public CommonResponse add(@RequestBody Para para) {
        paraService.add(para);
        return CommonResponse.success();
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody Para para) {
        paraService.update(para);
        return CommonResponse.success();
    }

    @GetMapping("/delete")
    public CommonResponse delete(Integer id) {
        paraService.delete(id);
        return CommonResponse.success();
    }

}
