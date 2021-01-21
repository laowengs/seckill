package com.laowengs.seckill.client;

import com.laowengs.seckill.db.EnableSeckillDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSeckillDB
public class SeckillClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillClientApplication.class,args);
    }
}
