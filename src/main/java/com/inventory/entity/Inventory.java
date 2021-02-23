package com.inventory.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="inventory")
@IdClass(InventoryPK.class)
public class Inventory implements Serializable {

    @ManyToOne
    @JoinColumn(name = "store_id")
    @MapsId
    private Store store;
    @Id
    private Integer skuId;

    private Integer quantity;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
