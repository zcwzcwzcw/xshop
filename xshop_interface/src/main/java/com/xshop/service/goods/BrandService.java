package com.xshop.service.goods;

import com.xshop.pojo.goods.Brand;

import java.util.List;

/**
 * 品牌服务接口
 * @author zcw
 * @date 2019/11/9
 */
public interface BrandService {
    /**
     * 查找所有品牌信息
     */
    List<Brand> findAll();
}
