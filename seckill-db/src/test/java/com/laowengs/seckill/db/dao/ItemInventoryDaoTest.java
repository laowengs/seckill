package com.laowengs.seckill.db.dao;

import com.laowengs.seckill.db.MybatisConfig;
import com.laowengs.seckill.db.po.ItemInventory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

class ItemInventoryDaoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
        ItemInventoryDao itemInventoryDao = context.getBean(ItemInventoryDao.class);
        for (int i = 0; i < 100; i++) {
            System.out.println(itemInventoryDao.selectByPrimaryKey(1L));
        }
    }
}