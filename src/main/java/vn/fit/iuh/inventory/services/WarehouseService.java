package vn.fit.iuh.inventory.services;

import vn.fit.iuh.inventory.entities.response.ResWarehouseDTO;

import java.util.List;

public interface WarehouseService {
    List<ResWarehouseDTO> getAllWarehouses();
    ResWarehouseDTO getWarehouseById(int id);
    ResWarehouseDTO createWarehouse(ResWarehouseDTO warehouseDTO);
    ResWarehouseDTO updateWarehouse(int id, ResWarehouseDTO warehouseDTO);
    void deleteWarehouse(int id);
}
