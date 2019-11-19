package com.xshop.pojo.goods;

import lombok.Data;

import java.util.List;

/**
 * 前端传来的商品对象
 * @author zcw
 * @date 2019/11/17
 */
@Data
public class GoodsDTO {
    private Spu spu;
    private List<Sku> skuList;
}