package com.inventory.repository;

import com.inventory.entity.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

    @Query(value = "SELECT s.id, s.name, s.bopus " +
            "FROM store as s JOIN inventory as i " +
            "ON s.id=i.store_id " +
            "WHERE sku_id in (:skuId) " +
            "AND quantity > 0", nativeQuery = true)
    public List<Store> getStoresWithSku(@Param("skuId") Integer skuId);

    @Query(value = "SELECT s.id, s.name, s.bopus " +
            "FROM store as s JOIN inventory as i " +
            "ON s.id=i.store_id " +
            "WHERE sku_id in (:skuId) " +
            "AND bopus is true " +
            "AND quantity > 0", nativeQuery = true)
    public List<Store> getStoresWithSkuBopusEligible(@Param("skuId") Integer skuId);
}
