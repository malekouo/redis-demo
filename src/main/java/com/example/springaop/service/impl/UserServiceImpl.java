package com.example.springaop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.springaop.pojo.UserInfoDTO;
import com.example.springaop.service.UserService;
import com.example.springaop.util.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    /**
     * 这里存储对象信息应该用hash的
     * @param userUid
     * @return
     */
    @Override
    public UserInfoDTO getUserInfo(String userUid) {
        Jedis jedis = JedisUtil.getJedis();
        //先查询redis中是否存在该key
        String key = "user:" + userUid;
        if (jedis.exists(key)) {
            log.info("从redis中查询数据");
            return JSONObject.parseObject(jedis.get(key), UserInfoDTO.class);
        }
        //不存在的话，就从数据库中查询，然后存在redis中，并且返回出去
        //模拟数据库
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserName("张三");
        userInfoDTO.setAge("19");
        userInfoDTO.setUserPhone("18189898989");
        jedis.set(key, JSONObject.toJSONString(userInfoDTO));
        jedis.close();
        log.info("从数据库中查询数据");
        return userInfoDTO;
    }
}
