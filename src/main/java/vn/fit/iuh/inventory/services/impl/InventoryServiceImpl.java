package vn.fit.iuh.inventory.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fit.iuh.inventory.entities.Inventory;
import vn.fit.iuh.inventory.entities.Warehouse;
import vn.fit.iuh.inventory.entities.response.ResInventoryDTO;
import vn.fit.iuh.inventory.mappers.InventoryMapper;
import vn.fit.iuh.inventory.repository.InventoryRepository;
import vn.fit.iuh.inventory.repository.WarehouseRepository;
import vn.fit.iuh.inventory.services.InventoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public List<ResInventoryDTO> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(inventoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResInventoryDTO getInventoryById(int id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        return inventoryMapper.toDTO(inventory);
    }

    @Override
    public ResInventoryDTO createInventory(ResInventoryDTO inventoryDTO) {
        Inventory inventory = inventoryMapper.toEntity(inventoryDTO);
        Warehouse warehouse = warehouseRepository.findById(inventoryDTO.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        inventory.setWarehouse(warehouse);
        inventory = inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    @Override
    public ResInventoryDTO updateInventory(int id, ResInventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setStockStatus(inventoryDTO.getStockStatus());
        inventory.setLastUpdated(inventoryDTO.getLastUpdated());
        Warehouse warehouse = warehouseRepository.findById(inventoryDTO.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
        inventory.setWarehouse(warehouse);
        inventory = inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(inventory);
    }

    @Override
    public void deleteInventory(int id) {
        inventoryRepository.deleteById(id);
    }
}
