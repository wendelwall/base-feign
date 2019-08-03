package com.base.basefeign.aic.controller;

import com.base.basefeign.aic.model.Subject;
import com.base.basefeign.aic.model.User;
import com.base.basefeign.aic.service.FeignService;
import com.base.basefeign.aic.service.RoleService;
import com.base.basefeign.aic.service.UserService;
import com.base.basefeign.utils.FeignUtils;
import com.base.basefeign.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：sunrise
 * @description ：
 * @copyright ：	Copyright 2019 yowits Corporation. All rights reserved.
 * @create ：2019/8/1 20:38
 */
@RestController
public class TestController {
    @Autowired
    RoleService roleService;
    @Autowired
    FeignService feignService;

    /**
     * 原始feign调用
     * @return
     */
    @GetMapping(value = "/rest/getRole")
    public User getRole(){
        return roleService.getRole();
    }

    /**
     * 动态根据url调用（GET）
     * @return
     */
    @GetMapping(value = "/rest/getUser")
    public User getUser(){
        Subject subject = SpringUtils.getBean(Subject.class);
        System.out.println(subject.getName());
        UserService userService = FeignUtils.getBean("http://localhost:8888/v1/get", UserService.class);
        return userService.getUser();
    }

    /**
     * 动态根据url调用（POST）
     * @return
     */
    @PostMapping(value = "/rest/createUser")
    public User createUser(@RequestBody User user){
        UserService userService = FeignUtils.getBean("http://localhost:8888/v2/create", UserService.class);
        return userService.createUser(user);
    }
}
