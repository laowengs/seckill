package com.laowengs.seckill.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seckill")
public class SeckillController {

    @RequestMapping("buyItem")
    public Object buyItem(BuyItemInfoInput buyItemInfoInput){
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

