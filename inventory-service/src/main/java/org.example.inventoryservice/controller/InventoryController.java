package org.example.product.controller;

import lombok.RequiredArgsConstructor;
import org.example.product.dto.InventoryRequest;
import org.example.product.service.InventoryService;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing inventory.
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    /**
     * GET /{productId} — returns the current stock for a product.
     */
    @GetMapping("/{productId}")
    public int getStock(@PathVariable Long productId) {
        return inventoryService.getStock(productId);
    }

    /**
     * POST / — creates or updates the stock entry for a product.
     */
    @PostMapping({ "", "/" })
    public void createOrUpdate(@RequestBody InventoryRequest request) {
        inventoryService.createOrUpdateStock(request.productId(), request.quantity());
    }
}