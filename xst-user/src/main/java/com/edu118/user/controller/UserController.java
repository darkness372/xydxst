package com.edu118.user.controller;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu118.user.dao.UserDao;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu118.common.entity.user.UserEntity;
import com.edu118.common.service.user.UserService;
import com.edu118.common.utils.PageUtils;
import com.edu118.common.utils.R;


/**
 *
 *
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
@RestController
@RequestMapping("xst/user")
public class UserController {
    @Reference
    private UserService userService;

    /**
     * 级联查询
     */
    @RequestMapping("/findAll")
    public R findAll(){
        List<UserEntity> userEntity = userService.getUserAllProduct();
        for (UserEntity ue : userEntity) {
            System.out.println(ue);
        }
        return R.ok().put("page", userEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uid}")
    public R info(@PathVariable("uid") Integer uid){
		UserEntity user = userService.getById(uid);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] uids){
		userService.removeByIds(Arrays.asList(uids));

        return R.ok();
    }

}
