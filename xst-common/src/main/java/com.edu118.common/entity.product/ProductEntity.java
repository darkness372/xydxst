package com.edu118.common.entity.product;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.edu118.common.entity.user.UserEntity;
import lombok.*;

/**
 * 
 * 
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("xst_product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer pid;
	/**
	 * 产品名称
	 */
	private String pname;

	private List<UserEntity> userEntities;

	public ProductEntity(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "ProductEntity{" +
				"pid=" + pid +
				", pname='" + pname + '\'' +
				'}';
	}
}
