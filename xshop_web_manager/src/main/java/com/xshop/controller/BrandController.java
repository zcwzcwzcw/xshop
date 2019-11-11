package com.xshop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Brand;
import com.xshop.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 品牌控制器类
 * @author zcw
 * @date 2019/11/9
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    /**
     * 查询所有
     */
    @GetMapping("/findAll.do")
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    /**
     * 分页查询
     */
    @GetMapping("/findPage.do")
    public PageResult<Brand> findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    /**
     * 条件查询
     */
    @PostMapping("/findList.do")
    public List<Brand> findList(@RequestBody Map<String, Object> searchMap) {
        return brandService.findList(searchMap);
    }

    /**
     * 条件查询并分页
     */
    @PostMapping("/findPage.do")
    public PageResult<Brand> findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return brandService.findPage(searchMap, page, size);
    }

    /**
     * 根据id查询
     */
    @GetMapping("/findById.do")
    public Brand findById(Integer id) {
        return brandService.findById(id);
    }

    /**
     * 添加品牌
     */
    @PostMapping("/save.do")
    public CommonResponse<Brand> save(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    /**
     * 更新品牌
     */
    @PostMapping("/update.do")
    public CommonResponse<Brand> update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    /**
     * 根据id删除品牌
     */
    @PostMapping("/delete.do")
    public CommonResponse<Brand> delete(@RequestBody Brand brand) {
        return brandService.delete(brand.getId());
    }
}
