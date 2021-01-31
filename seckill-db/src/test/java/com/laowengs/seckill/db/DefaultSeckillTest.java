package com.laowengs.seckill.db;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class DefaultSeckillTest {
    static AnnotationConfigApplicationContext context;
    @BeforeAll
    static void setUp() {
        System.out.println("BeforeAll");
        context = new AnnotationConfigApplicationContext(SeckillDataSourceConfig.class);
    }

    @AfterAll
    static void afterAll() {
        context.close();
    }
    @Test
    void scramble() {
        //TODO 为什么会报错 找不到bean
        DefaultSeckill defaultSeckill = context.getBean(DefaultSeckill.class);
        defaultSeckill.scramble(1L);
    }
}