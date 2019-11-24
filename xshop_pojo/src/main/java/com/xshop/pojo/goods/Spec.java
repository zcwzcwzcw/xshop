package com.xshop.pojo.goods;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * spec实体类
 *
 * @author zcw
 */
@Data
@Table(name = "tb_spec")
public class Spec implements Serializable {
    /** id */
    @Id
    private Integer id;

    /** 名称 */
    private String name;

    /** 规格选项 */
    private String options;

    /** 排序 */
    private Integer seq;

    /** 模板ID */
    private Integer templateId;
}
