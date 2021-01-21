package com.laowengs.seckill.db.seckilldb.dao;

import com.laowengs.seckill.db.SeckillDataSourceConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ItemInventoryDaoTest {


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

    /*
    @BeforeEach
    void setUpBeforeEach() {
        System.out.println("BeforeEach");
    }
*/

    @Test
    void selectByPrimaryKey() {
        ItemInventoryDao itemInventoryDao = context.getBean(ItemInventoryDao.class);
        System.out.println(itemInventoryDao.selectByPrimaryKey(1L));
    }

    @Test
    void updateItemNum() {
        ItemInventoryDao itemInventoryDao = context.getBean(ItemInventoryDao.class);
        System.out.println(itemInventoryDao.updateItemNum(1L, 10L, 1L));
    }
}