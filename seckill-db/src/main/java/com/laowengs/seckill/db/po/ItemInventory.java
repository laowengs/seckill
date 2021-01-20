package com.laowengs.seckill.db.po;

public class ItemInventory {
    private Long itemId;
    private Long itemNum;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemNum() {
        return itemNum;
    }

    public void setItemNum(Long itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "ItemInventory{" +
                "itemId=" + itemId +
                ", itemNum=" + itemNum +
                '}';
    }
}
