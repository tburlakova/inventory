package com.inventory.service;

import com.inventory.entity.Store;

import java.util.List;

public interface IStoreService {

    List<Store> findAll();

    List<Store> getStoresWithSku(Integer skuId);

    List<Store> getStoresWithSkuBopusEligible(Integer skuId);

    Store getStore(Integer id);

    Store addStore(Store store);

    Store updateStore(Store store);

    void deleteStore(Integer id);
}
