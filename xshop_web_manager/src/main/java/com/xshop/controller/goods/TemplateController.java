package com.xshop.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Template;
import com.xshop.service.goods.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Reference
    private TemplateService templateService;

    @GetMapping("/findAll")
    public List<Template> findAll() {
        return templateService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Template> findPage(int page, int size) {
        return templateService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Template> findList(@RequestBody Map<String, Object> searchMap) {
        return templateService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Template> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return templateService.findPage(searchMap, page, size);
    }

    @GetMapping("/findById")
    public Template findById(Integer id) {
        return templateService.findById(id);
    }


    @PostMapping("/add")
    public CommonResponse add(@RequestBody Template template) {
        templateService.add(template);
        return CommonResponse.success();
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody Template template) {
        templateService.update(template);
        return CommonResponse.success();
    }

    @GetMapping("/delete")
    public CommonResponse delete(Integer id) {
        templateService.delete(id);
        return CommonResponse.success();
    }

}
