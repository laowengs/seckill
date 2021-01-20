package com.laowengs.seckill.db.dao;

import com.laowengs.seckill.db.po.ItemInventory;

public interface ItemInventoryDao {
    ItemInventory selectByPrimaryKey(Long itemId);
}