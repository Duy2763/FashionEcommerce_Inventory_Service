package vn.fit.iuh.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.fit.iuh.inventory.entities.response.ResWarehouseDTO;
import vn.fit.iuh.inventory.services.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<ResWarehouseDTO> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public ResWarehouseDTO getWarehouseById(@PathVariable int id) {
        return warehouseService.getWarehouseById(id);
    }

    @PostMapping
    public ResWarehouseDTO createWarehouse(@RequestBody ResWarehouseDTO warehouseDTO) {
        return warehouseService.createWarehouse(warehouseDTO);
    }

    @PutMapping("/{id}")
    public ResWarehouseDTO updateWarehouse(@PathVariable int id, @RequestBody ResWarehouseDTO warehouseDTO) {
        return warehouseService.updateWarehouse(id, warehouseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable int id) {
        warehouseService.deleteWarehouse(id);
    }
}
