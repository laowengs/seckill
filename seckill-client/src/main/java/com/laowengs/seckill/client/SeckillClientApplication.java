package com.laowengs.seckill.client;

import com.laowengs.seckill.db.EnableSeckillFromDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableSeckillFromDB
public class SeckillClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillClientApplication.class,args);
    }
}
