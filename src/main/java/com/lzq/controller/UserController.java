package com.lzq.controller;


import com.alibaba.fastjson.JSON;
import com.lzq.common.Resullt;
import com.lzq.pojo.User;
import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result createUser(@RequestBody String data) {

        User user = JSON.parseObject(data, User.class);
        return userService.createUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public Resullt.Result updateUser(@RequestBody String data){
        User user = JSON.parseObject(data, User.class);
        return userService.updateUser(user);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    Resullt.Result deleteUse(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    User getUserById(@PathVariable Integer userId) {
      return userService.getUserById(userId);
    }

}
