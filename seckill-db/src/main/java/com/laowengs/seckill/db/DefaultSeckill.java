package com.laowengs.seckill.db;

import com.laowengs.seckill.core.Seckill;
import com.laowengs.seckill.db.seckilldb.dao.ItemInventoryDao;
import com.laowengs.seckill.db.seckilldb.po.ItemInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSeckill implements Seckill {

    private ItemInventoryDao itemInventoryDao;

    @Autowired
    public DefaultSeckill(ItemInventoryDao itemInventoryDao) {
        this.itemInventoryDao = itemInventoryDao;
    }

    @Override
    public void scramble(Long itemId) {
        ItemInventory itemInventory = itemInventoryDao.selectByPrimaryKey(itemId);
        if(itemInventory != null){
            itemInventoryDao.updateItemNum(itemId,itemInventory.getItemNum()-1,itemInventory.getItemNum());
        }
    }
}
