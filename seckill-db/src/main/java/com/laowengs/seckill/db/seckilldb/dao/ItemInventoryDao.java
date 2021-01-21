package com.laowengs.seckill.db.seckilldb.dao;

import com.laowengs.seckill.db.seckilldb.po.ItemInventory;

public interface ItemInventoryDao {
    ItemInventory selectByPrimaryKey(Long itemId);

    Long updateItemNum(Long itemId, Long newItemNum, Long oldItemNum);
}