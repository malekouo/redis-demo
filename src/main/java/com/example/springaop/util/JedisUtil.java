package com.example.springaop.util;


import com.example.springaop.SpringAopApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;


@Component
public class JedisUtil {
    //@Autowired注解是无法注入 static的，所以 通过  @PostConstruct 注解，把jedisPool的给 静态赋值
    private static JedisPool redisPoolFactory;

    @Autowired
    private JedisPool jedisPool;

  @PostConstruct
  public void init() {
      redisPoolFactory = jedisPool;
  }

    public static Jedis getJedis() {
        return redisPoolFactory.getResource();
    }

    public static void closeJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
