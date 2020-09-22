package com.edu118.salary.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu118.common.entity.salary.SalaryEntity;
import com.edu118.common.service.salary.SalaryService;
import com.edu118.common.utils.PageUtils;
import com.edu118.common.utils.R;

/**
 * 考勤表
 *
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
@RestController
@RequestMapping("xst/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = salaryService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @GetMapping("/salinfo")
    public R info(){
        List<SalaryEntity> list = salaryService.list();
        System.out.println(list);
        return R.ok().put("salary", list);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SalaryEntity salary){
		salaryService.save(salary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SalaryEntity salary){
		salaryService.updateById(salary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		salaryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
