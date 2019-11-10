package com.xshop.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xshop.dao.BrandMapper;
import com.xshop.pojo.goods.Brand;
import com.xshop.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 品牌服务实现类
 * @author zcw
 * @date 2019/11/9
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
