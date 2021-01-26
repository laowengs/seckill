package com.laowengs.seckill.db.seckilldb.po;

import java.io.Serializable;
import java.util.Date;

/**
 * item_inventory
 * @author 
 */
public class ItemInventory implements Serializable {
    private Long itemId;

    private Long itemNum;

    private Date createDate;

    private Date statusDate;

    private Integer statusCode;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ItemInventory{" +
                "itemId=" + itemId +
                ", itemNum=" + itemNum +
                ", createDate=" + createDate +
                ", statusDate=" + statusDate +
                ", statusCode=" + statusCode +
                '}';
    }
}