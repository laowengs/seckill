package com.laowengs.seckill.client.controller;

import com.laowengs.seckill.db.DefaultSeckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seckill")
public class SeckillController {

    private DefaultSeckill seckill;

    @Autowired
    public SeckillController(DefaultSeckill seckill) {
        this.seckill = seckill;
    }

    @RequestMapping("buyItem")
    public Object buyItem(BuyItemInfoInput buyItemInfoInput){
        seckill.scramble(buyItemInfoInput.getItemId());
        return "success";
    }
}

class BuyItemInfoInput{
    private Long itemId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "BuyItemInfoInput{" +
                "itemId=" + itemId +
                '}';
    }
}

