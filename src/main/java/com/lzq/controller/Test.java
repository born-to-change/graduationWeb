package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.common.Resullt;
import com.lzq.mapper.UserMapper;
import com.lzq.pojo.User;
import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class Test {
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String homeHandler() {
        return "home";
    }

    @RequestMapping("/test")
    public String testHandler() {
        return "test";
    }

    /**
     * 使用JSON作为响应内容
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result createUser(@RequestBody String data) {

        System.out.println("data:" + data);

        User user = JSON.parseObject(data, User.class);
        return userService.createUser(user);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    User getPerson(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
}

