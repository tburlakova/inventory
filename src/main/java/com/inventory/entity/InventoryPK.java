package com.inventory.entity;

import java.io.Serializable;

public class InventoryPK implements Serializable {

    protected Store store;
    protected Integer skuId;

    public InventoryPK() { }

    public InventoryPK(Store store, Integer skuId) {

        this.store = store;
        this.skuId = skuId;
    }
}
