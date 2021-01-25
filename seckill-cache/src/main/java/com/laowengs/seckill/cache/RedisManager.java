package com.laowengs.seckill.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

public class RedisManager {

    private static final  Logger logger = LoggerFactory.getLogger(RedisManager.class);

    private final JedisPool jedisPool;

    public RedisManager() throws RedisException {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("redis.properties"));
        } catch (IOException e) {
            logger.error("redis.properties文件异常", e);
            throw new RedisException("redis.properties文件异常",e);
        }

        String host = properties.getProperty("host");
        String password = properties.getProperty("password");
        int port = Integer.parseInt(properties.getProperty("port"));
        int timeout = Integer.parseInt(properties.getProperty("timeout"));
        int maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
        int maxWaitMillis = Integer.parseInt(properties.getProperty("maxWaitMillis"));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        jedisPool = new JedisPool(jedisPoolConfig, host, port,timeout, password);

        logger.info("创建redis连接成功");
    }

    public Jedis getResource(){
        return jedisPool.getResource();
    }
}
