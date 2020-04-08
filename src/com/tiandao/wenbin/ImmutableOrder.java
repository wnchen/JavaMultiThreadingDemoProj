package com.tiandao.wenbin;

public class ImmutableOrder {

    private final String id;
    private final String customerId;
    private final String goodsId;
    private final Long ts;

    ImmutableOrder(String id, String customerId, String goodsId, Long ts) {
        this.id = id;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.ts = ts;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public Long getTs() {
        return ts;
    }
}

