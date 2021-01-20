package com.laowengs.seckill.db.dao;

import com.laowengs.seckill.db.MybatisConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ItemInventoryDaoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        ItemInventoryDao itemInventoryDao = context.getBean(ItemInventoryDao.class);
        System.out.println(itemInventoryDao.selectByPrimaryKey(1L));
    }
}