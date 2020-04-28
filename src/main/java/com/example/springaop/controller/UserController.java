package com.example.springaop.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springaop.service.UserService;
import com.example.springaop.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * jedis客户端缓存数据
     *
     * @param userUid
     * @return
     */
    @RequestMapping(value = "/getUserInfo/{userUid}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(@PathVariable String userUid) {
        return JSONObject.toJSONString(userService.getUserInfo(userUid));
    }

    /**
     * redisTemplate客户端缓存数据
     *
     * @param userUid
     * @return
     */
    @RequestMapping(value = "/getUserInfoByUserUid/{userUid}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfoByUserUid(@PathVariable String userUid) {
        return JSONObject.toJSONString(userService.getUserInfoByUserUid(userUid));
    }

    /**
     * 使用redis 实现 同一个ip ,一分钟内只能访问 5次
     *
     * @return
     */
    @RequestMapping(value = "/visit", method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest httpServletRequest) {
        // fixme 这个ip的获取方式不对，每次拿到的都是本机的
        String ip = httpServletRequest.getRemoteAddr();
        String key = "visit:" + ip;
        if (RedisUtil.hasKey(key)) {
            if (Integer.valueOf(String.valueOf(RedisUtil.get(key))) >= 5) {
                return "访问次数过多,"+RedisUtil.getExpire(key)+"s之后再来";
            }
            log.info("IP{{}}访问次数加一",ip);
            RedisUtil.incr(key, 1);
        } else {
            log.info("第一次进来");
            RedisUtil.set(key, 1, 60);
        }
        return "访问成功，访问次数"+Integer.valueOf(String.valueOf(RedisUtil.get(key)));
    }


}
