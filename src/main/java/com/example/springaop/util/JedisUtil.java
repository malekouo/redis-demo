package com.example.springaop.util;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.Map;


@Component
public class JedisUtil {
    //@Autowired注解是无法注入 static的，所以 通过  @PostConstruct 注解，把jedisPool的给 静态赋值
    private static JedisPool redisPoolFactory;

    private static Jedis jedis;

    @Autowired
    private JedisPool jedisPool;

    @PostConstruct
    public void init() {
        //初始化连接池
        redisPoolFactory = jedisPool;
        //初始化jedis实例
        if (jedis == null) {
            jedis = jedisPool.getResource();
        }

    }

    public static Jedis getJedis() {
        return redisPoolFactory.getResource();
    }

    //检查key是否存在
    public static Boolean exists(String key) {
        return jedis.exists(key);
    }

    //String类型操作
    public static String set(String key, String value) {
        return jedis.set(key, value);
    }

    /**
     * @param key
     * @param seconds 设置过期时间  单位是 s
     * @param value
     * @return
     */
    public static String setEx(String key, int seconds, String value) {
        return jedis.setex(key, seconds, value);
    }

    /**
     * 主要用于分布式锁
     *
     * @param key     设置 key
     * @param seconds 设置过期时间，单位是s
     * @param value   设置vlue
     * @return
     */
    public static Boolean setNx(String key, int seconds, String value) {
        Long result = jedis.setnx(key, value);
        if (result == 1) {
            //设置成功的话，添加过期时间，防止宕机死锁
            jedis.expire(key, seconds);
            return true;
        }
        return false;
    }

    /**
     * 按照key获取值
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return jedis.get(key);
    }

    /**
     * 存放 hash（单个字段）
     *
     * @param key
     * @return
     */
    public static Boolean hSet(String key, String field, String value) {
        return jedis.hset(key, field, value) == 1;
    }

    /**
     * 存放hash（多个字段）
     *
     * @param key
     * @return
     */
    public static String hmSet(String key, Map<String, String> filedMap) {
        String hmset = jedis.hmset(key, filedMap);
        return hmset;
    }

    /**
     * 获取单个hash 的属性 和字段值
     *
     * @param key
     * @param field
     * @return
     */
    public static String hGet(String key, String field) {
        String hget = jedis.hget(key, field);
        return hget;
    }

    /**
     * hahs获取所有的属性 和 字段值
     *
     * @param key
     * @return
     */
    public static Map<String, String> hGetAll(String key) {
        return jedis.hgetAll(key);
    }

    /**
     * 删除 hash 中的对象某个字段（属性和属性值 都被删除）
     *
     * @param key
     * @param field
     * @return
     */
    public static Boolean hDel(String key, String field) {
        return jedis.hdel(key, field) == 1;
    }

    /**
     * @param clazz
     * @param <T>
     * @return 返回传入的类
     * @paramapm key hash对象对应的key
     */
    public static <T> T hashToObj(String key, Class<T> clazz) {
        Map<String, String> map = jedis.hgetAll(key);
        //将map集合转换为对象
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }

}
