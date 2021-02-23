package com.inventory.service;

import com.inventory.entity.Inventory;

import java.util.List;

public interface IInventoryService {

    List<Inventory> listInventories();

    void upsert(Inventory inventory);
}
