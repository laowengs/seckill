package com.laowengs.seckill.db;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(SeckillDataSourceConfig.class)
@ComponentScan("com.laowengs.seckill.db")
public @interface EnableSeckillFromDB {
}
