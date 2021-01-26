package com.laowengs.seckill.cache;

import com.laowengs.seckill.db.SeckillDataSourceConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SeckillDataSourceConfig.class,SeckillCacheConfig.class})
class SeckillPreheatProcessorTest {

    @Autowired
    private SeckillPreheatProcessor seckillPreheatProcessor;

    @Test
    void timingPreheat() {
        seckillPreheatProcessor.timingPreheat();
    }

    @Test
    void preheat() {
        seckillPreheatProcessor.preheat();
    }
}