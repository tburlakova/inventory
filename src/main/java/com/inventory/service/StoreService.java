package com.inventory.service;

import com.inventory.entity.Store;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements IStoreService {

    @Autowired
    private StoreRepository repository;

    public List<Store> findAll() {

        return (List<Store>) repository.findAll();
    }

    @Override
    public List<Store> getStoresWithSku(Integer skuId) {

        return repository.getStoresWithSku(skuId);
    }

    @Override
    public List<Store> getStoresWithSkuBopusEligible(Integer skuId) {

        return repository.getStoresWithSkuBopusEligible(skuId);
    }

    @Override
    public Store getStore(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Override
    public Store addStore(Store store) {
        return repository.save(store);
    }

    @Override
    public Store updateStore(Store store) {
        Store storeToUpdate = repository.findById(store.getStoreId())
                .orElseThrow(() -> new ResourceNotFoundException(store.getStoreId().toString()));
        storeToUpdate.setName(store.getName());
        storeToUpdate.setBopusEligible(store.getBopusEligible());
        return repository.save(storeToUpdate);
    }

    @Override
    public void deleteStore(Integer id) {

        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));

        repository.deleteById(id);
    }
}
