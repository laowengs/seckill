package com.laowengs.seckill.cache;

import com.laowengs.seckill.db.seckilldb.dao.ItemInventoryDao;
import com.laowengs.seckill.db.seckilldb.po.ItemInventory;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class SeckillPreheatProcessor {
    private static final Logger logger = LoggerFactory.getLogger(SeckillPreheatProcessor.class);

    private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("seckill-preheat-pool-%d").daemon(false).build());
    private final ItemInventoryDao itemInventoryDao;
    private final RedisManager redisManager;

    @Autowired
    public SeckillPreheatProcessor(ItemInventoryDao itemInventoryDao) throws RedisException {
        this.itemInventoryDao = itemInventoryDao;
        this.redisManager = new RedisManager();
    }

    private void preheat() {

        long initialDelay = 0;
        long period = 10;

        //创建并执行一个周期性操作，该操作将在给定的初始延迟后首先启用，然后在给定的时间段内启用
        //第一次执行 在initialDelay后
        //第二次执行 在initialDelay+1*period 后
        //第三次执行 在initialDelay+2*period 后
        executorService.scheduleAtFixedRate(() -> {

            //修改为查询指定时间的
            Date beginDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(beginDate);
            calendar.add(Calendar.SECOND,300);
            Date endDate = calendar.getTime();

            List<ItemInventory> itemInventories = itemInventoryDao.selectByDateRange(beginDate,endDate);
            if (itemInventories != null && !itemInventories.isEmpty()) {
                for (ItemInventory itemInventory : itemInventories) {
                    Jedis jedis = redisManager.getResource();
                    String key = "seckill-" + itemInventory.getItemId();
                    //怎么避免重复预热
                    //1.定时任务，按商品id分发预热任务一次，不要重复执行
                    for (long i = 0; i < itemInventory.getItemNum(); i++) {
                        jedis.lpush(key,String.valueOf(itemInventory.getItemNum()));
                    }
                }
            }
        }, initialDelay, period, TimeUnit.SECONDS);

    }
}
