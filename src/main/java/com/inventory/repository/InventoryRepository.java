package com.inventory.repository;

import com.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    @Modifying
    @Query(value = "INSERT INTO inventory(store_id, sku_id, quantity) " +
            "VALUES(:store_id, :sku_id, :quantity) " +
            "ON CONFLICT (store_id, sku_id) DO UPDATE " +
            "SET quantity = :quantity", nativeQuery = true)
    @Transactional
    void upsert(@Param("store_id") int storeId, @Param("sku_id") int skuId, @Param("quantity") int quantity);
}
