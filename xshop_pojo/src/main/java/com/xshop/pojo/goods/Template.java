package com.xshop.pojo.goods;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * template实体类
 * @author zcw
 */
@Data
@Table(name="tb_template")
public class Template implements Serializable{
	/** id */
	@Id
	private Integer id;

	/** 模板名称 */
	private String name;

	/** 规格数量 */
	private Integer specNum;

	/** 参数数量 */
	private Integer paraNum;
}
