package com.inventory.controller;

import com.inventory.ApiError;
import com.inventory.entity.Inventory;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @GetMapping("/inventories")
    public List<Inventory> listInventory() {
        return inventoryService.listInventories();
    }

    @PutMapping(value = "/inventories")
    public void upsertInventory(@RequestBody Inventory inventory) {
        inventoryService.upsert(inventory);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiError handleException(ResourceNotFoundException ex) {

        return new ApiError(ex.getStatusCode(), ex.getMessage());
    }
}
