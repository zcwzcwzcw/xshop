package com.xshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 *
 * @author zcw
 * @date 2019/11/11
 */
@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    /** 总记录数 */
    private Long total;
    /** 当前记录 */
    private List<T> rows;
}
