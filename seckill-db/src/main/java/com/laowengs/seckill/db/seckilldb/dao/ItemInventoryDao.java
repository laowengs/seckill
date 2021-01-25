package com.laowengs.seckill.db.seckilldb.dao;

import com.laowengs.seckill.db.seckilldb.po.ItemInventory;

import java.util.Date;
import java.util.List;

public interface ItemInventoryDao {
    ItemInventory selectByPrimaryKey(Long itemId);

    Long updateItemNum(Long itemId, Long newItemNum, Long oldItemNum);

    List<ItemInventory> selectAll();

    List<ItemInventory> selectByDateRange(Date beginDate, Date endDate);
}