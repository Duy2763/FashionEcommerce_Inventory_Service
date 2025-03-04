package vn.fit.iuh.inventory.services;

import vn.fit.iuh.inventory.entities.response.ResInventoryDTO;

import java.util.List;

public interface InventoryService {
    List<ResInventoryDTO> getAllInventories();
    ResInventoryDTO getInventoryById(int id);
    ResInventoryDTO createInventory(ResInventoryDTO inventoryDTO);
    ResInventoryDTO updateInventory(int id, ResInventoryDTO inventoryDTO);
    void deleteInventory(int id);
}
