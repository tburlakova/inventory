package com.inventory.service;

import com.inventory.entity.Inventory;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.repository.InventoryRepository;
import com.inventory.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Inventory> listInventories() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    @Override
    public void upsert(Inventory inventory) {

        storeRepository.findById(inventory.getStore().getStoreId())
                .orElseThrow(() -> new ResourceNotFoundException(inventory.getStore().getStoreId().toString()));
        inventoryRepository.upsert(inventory.getStore().getStoreId(), inventory.getSkuId(), inventory.getQuantity());
    }
}
