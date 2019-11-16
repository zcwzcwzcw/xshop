package com.xshop.pojo.goods;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * para实体类
 * @author zcw
 */
@Data
@Table(name="tb_para")
public class Para implements Serializable{
	/** id */
	@Id
	private Integer id;

	/** 名称 */
	private String name;

	/** 选项 */
	private String options;

	/** 排序 */
	private Integer seq;

	/** 模板ID */
	private Integer templateId;
}
