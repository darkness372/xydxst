package com.edu118.user.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu118.common.entity.product.ProductEntity;
import org.apache.catalina.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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

        return R.ok().put("data", userEntity);
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

    /**
     * 登录方法
     */
    @ResponseBody
    @PostMapping("/login")
    public R login(@RequestBody UserEntity userEntity){
        System.out.println("请求到的数据为:    "+userEntity);
        QueryWrapper qw = new QueryWrapper<UserEntity>();
        qw.eq("username",userEntity.getUsername());
        qw.eq("password",userEntity.getPassword());
        UserEntity result = userService.getOne(qw);
        System.out.println("查询的结果：" + result);
        if (result == null) {
            return R.error(1001,"用户名或密码错误！");
        }
        result.setPassword("");
        return R.ok("登陆成功！").put("data",result);
    }
}
