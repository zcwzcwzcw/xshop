package com.xshop.service.goods;

import com.xshop.entity.CommonResponse;
import com.xshop.entity.PageResult;
import com.xshop.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

/**
 * 品牌服务接口
 *
 * @author zcw
 * @date 2019/11/9
 */
public interface BrandService {

    /**
     * 查找所有品牌信息
     */
    List<Brand> findAll();

    /**
     * 分页查询
     */
    PageResult<Brand> findPage(int page, int size);

    /**
     * 按条件查询
     */
    List<Brand> findList(Map<String, Object> searchMap);

    /**
     * 按条件查询并分页
     */
    PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据id查询
     */
    Brand findById(Integer id);

    /**
     * 添加品牌
     */
    CommonResponse<Brand> save(Brand brand);

    /**
     * 更新品牌
     */
    CommonResponse<Brand> update(Brand brand);

    /**
     * 根据id删除品牌
     */
    CommonResponse<Brand> delete(Integer id);

}
