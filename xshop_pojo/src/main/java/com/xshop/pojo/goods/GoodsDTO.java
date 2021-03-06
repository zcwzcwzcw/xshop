package com.xshop.pojo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 前端传来的商品对象
 *
 * @author zcw
 * @date 2019/11/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO implements Serializable {
    private Spu spu;
    private List<Sku> skuList;
}
