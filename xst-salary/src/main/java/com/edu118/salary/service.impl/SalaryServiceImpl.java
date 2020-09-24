package com.edu118.salary.service.impl;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu118.common.utils.PageUtils;
import com.edu118.common.utils.Query;

import com.edu118.salary.dao.SalaryDao;
import com.edu118.common.entity.salary.SalaryEntity;
import com.edu118.common.service.salary.SalaryService;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component("salaryService")
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryDao, SalaryEntity> implements SalaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SalaryEntity> page = this.page(
                new Query<SalaryEntity>().getPage(params),
                new QueryWrapper<SalaryEntity>()
        );
        return new PageUtils(page);
    }
}
