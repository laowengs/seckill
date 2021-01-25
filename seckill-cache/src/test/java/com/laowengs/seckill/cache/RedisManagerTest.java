package com.laowengs.seckill.cache;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;


class RedisManagerTest {
    static RedisManager redisManager;
    @BeforeAll
    static void beforeAll() throws RedisException {
        redisManager = new RedisManager();
    }

    @Test
    void set() {
        Jedis jedis = redisManager.getResource();
        jedis.set("username","wengjp1");
    }
    @Test
    void get() {
        Jedis jedis = redisManager.getResource();
        System.out.println(jedis.get("username"));
    }
}