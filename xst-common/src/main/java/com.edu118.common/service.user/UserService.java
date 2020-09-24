package com.edu118.common.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu118.common.utils.PageUtils;
import com.edu118.common.entity.user.UserEntity;

import java.util.List;

import java.util.Map;

/**
 * 
 *
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    public List<UserEntity> getUserAllProduct();
}

