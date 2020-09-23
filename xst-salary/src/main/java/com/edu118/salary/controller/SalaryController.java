package com.edu118.salary.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		SalaryEntity salary = salaryService.getById(id);

        return R.ok().put("salary", salary);
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

    /**
     * 薪资计算
     */
    @RequestMapping("/countSalary")
    public R countSalary(@RequestParam Map<String, Object> params){
        PageUtils page = salaryService.queryPage(params);
        double monthSalary = 6000;  //月薪
        double daySalary = monthSalary/26;  //日薪
        double hourSalary = daySalary/8;

        List<?> list = page.getList();
        HashMap<String, Double> map = new HashMap<String, Double>();
        for (Object obj : list) {
            System.out.println((SalaryEntity)obj);
            double salary =
                    monthSalary-((SalaryEntity) obj).getAbsDays()*daySalary*1.5
                            -((SalaryEntity) obj).getComeLate()*daySalary*0.5
                            -((SalaryEntity) obj).getLeaveEarly()*daySalary*0.5
                            +((SalaryEntity) obj).getOverTime()*hourSalary*3;
            System.out.println(((SalaryEntity) obj).getName()+"=>"+salary);

            map.put(((SalaryEntity) obj).getName(),salary);
//            System.out.println(map);
        }
        System.out.println(map);
        return R.ok().put("map", map);
    }

}
