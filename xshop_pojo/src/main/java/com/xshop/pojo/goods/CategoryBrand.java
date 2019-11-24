package com.xshop.pojo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 分类产品关联表
 *
 * @author zcw
 * @date 2019/11/24
 */
@Data
@Table(name = "tb_category_brand")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBrand implements Serializable {
    /** 分类id */
    @Id
    private Integer categoryId;

    /** 品牌id */
    @Id
    private Integer brandId;
}
