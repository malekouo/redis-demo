package com.example.springaop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserInfo/{userUid}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(@PathVariable String userUid) {
        return JSONObject.toJSONString(userService.getUserInfo(userUid));
    }
}
