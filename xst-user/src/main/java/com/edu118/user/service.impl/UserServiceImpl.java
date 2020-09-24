package com.edu118.user.service.impl;

import com.edu118.user.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu118.common.utils.PageUtils;
import com.edu118.common.utils.Query;

import com.edu118.common.entity.user.UserEntity;
import com.edu118.common.service.user.UserService;

@Component("userService")
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public List<UserEntity> getUserAllProduct(){
        List<UserEntity> userEntities = this.getBaseMapper().getUserAllProduct();
        return userEntities;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );
        return new PageUtils(page);
    }
}
