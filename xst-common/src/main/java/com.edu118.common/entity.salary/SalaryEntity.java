package com.edu118.common.entity.salary;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 考勤表
 * 
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
@Data
@TableName("xst_salary")
public class SalaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 员工姓名
	 */
	private String username;
	/**
	 * 上班天数
	 */
	private Integer days;
	/**
	 * 矿工天数
	 */
	private Integer absDays;
	/**
	 * 迟到次数
	 */
	private Integer comeLate;
	/**
	 * 早退次数
	 */
	private Integer leaveEarly;
	/**
	 * 加班时间
	 */
	private Integer overTime;

}
