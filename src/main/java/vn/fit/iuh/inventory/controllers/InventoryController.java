package vn.fit.iuh.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.fit.iuh.inventory.entities.response.ResInventoryDTO;
import vn.fit.iuh.inventory.services.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<ResInventoryDTO> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("/{id}")
    public ResInventoryDTO getInventoryById(@PathVariable int id) {
        return inventoryService.getInventoryById(id);
    }

    @PostMapping
    public ResInventoryDTO createInventory(@RequestBody ResInventoryDTO inventoryDTO) {
        return inventoryService.createInventory(inventoryDTO);
    }

    @PutMapping("/{id}")
    public ResInventoryDTO updateInventory(@PathVariable int id, @RequestBody ResInventoryDTO inventoryDTO) {
        return inventoryService.updateInventory(id, inventoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
    }
}
