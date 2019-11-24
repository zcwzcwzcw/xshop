package com.xshop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xshop.dao.CategoryBrandMapper;
import com.xshop.entity.BusinessException;
import com.xshop.pojo.goods.CategoryBrand;
import com.xshop.service.goods.CategoryBrandService;
import com.xshop.service.goods.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zcw
 * @date 2019/11/24
 */
@Slf4j
@Service(interfaceClass = CategoryBrandService.class)
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;


    @Override
    public void save(CategoryBrand categoryBrand) {
        if (categoryBrandMapper.selectCount(categoryBrand) > 0) {
            return;
        }
        int count = categoryBrandMapper.insert(categoryBrand);
        if (count <= 0) {
            log.error("创建分类品牌失败！categoryBrand:{}", categoryBrand);
            throw new BusinessException("创建分类品牌失败！");
        }
    }
}
