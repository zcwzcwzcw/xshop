package com.xshop.pojo.goods;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 品牌实体类
 *
 * @author zcw
 * @date 2019/11/9
 */
@Data
@Table(name = "tb_brand")
public class Brand implements Serializable {
    /** 品牌id */
    @Id
    private Integer id;

    /** 品牌名称 */
    private String name;

    /** 品牌图片地址 */
    private String image;

    /** 品牌首字母 */
    private Character letter;

    /** 排序 */
    private Integer seq;
}
