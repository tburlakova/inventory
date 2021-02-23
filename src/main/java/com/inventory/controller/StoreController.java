package com.inventory.controller;

import com.inventory.ApiError;
import com.inventory.entity.Store;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @GetMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("index.html");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/stores")
    public List<Store> listStores() {
        return storeService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/stores/haveSku", params = {"sku"})
    public List<Store> listStoresWithSku(@RequestParam(value = "sku") Integer sku) {
        return storeService.getStoresWithSku(sku);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/stores/haveSku/bopusEligible", params = {"sku"})
    public List<Store> listStoresWithSkuBopusEligible(@RequestParam(value = "sku") Integer sku) {
        return storeService.getStoresWithSkuBopusEligible(sku);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/stores/{id}")
    public Store findStoreById(@PathVariable Integer id) {
        return storeService.getStore(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/stores")
    public Store addStore(@RequestBody Store store) {
        return storeService.addStore(store);
    }

    @PutMapping(value = "/stores/{id}")
    public Store updateStore(@PathVariable Integer id, @RequestBody Store store) {
        return storeService.updateStore(store);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/stores/{id}")
    public void deleteStoreById(@PathVariable Integer id) {
        storeService.deleteStore(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiError handleException(ResourceNotFoundException ex) {

        return new ApiError(ex.getStatusCode(), ex.getMessage());
    }
}
