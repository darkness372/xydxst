package com.edu118.common.service.salary;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu118.common.utils.PageUtils;
import com.edu118.common.entity.salary.SalaryEntity;

import java.util.List;
import java.util.Map;

/**
 * 考勤表
 *
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
public interface SalaryService extends IService<SalaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

