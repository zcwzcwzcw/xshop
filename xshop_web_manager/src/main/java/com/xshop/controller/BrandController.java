package com.xshop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xshop.pojo.goods.Brand;
import com.xshop.service.goods.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/findAll.do")
    public List<Brand> findAll() {
        return brandService.findAll();
    }
}
