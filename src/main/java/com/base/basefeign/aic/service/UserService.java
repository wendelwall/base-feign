package com.base.basefeign.aic.service;

import com.base.basefeign.aic.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ：sunrise
 * @description ：动态url远程调用
 * @copyright ：	Copyright 2019 yowits Corporation. All rights reserved.
 * @create ：2019/8/2 21:23
 */
@FeignClient(name = "UserService")
public interface UserService {

//    @RequestLine("GET")
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    User getUser();

    @PostMapping
    User createUser(@RequestBody User user);
}
