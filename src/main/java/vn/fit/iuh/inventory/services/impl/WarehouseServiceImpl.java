package vn.fit.iuh.inventory.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fit.iuh.inventory.entities.Warehouse;
import vn.fit.iuh.inventory.entities.response.ResWarehouseDTO;
import vn.fit.iuh.inventory.mappers.WarehouseMapper;
import vn.fit.iuh.inventory.repository.WarehouseRepository;
import vn.fit.iuh.inventory.services.WarehouseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<ResWarehouseDTO> getAllWarehouses() {
        return warehouseRepository.findAll().stream()
                .map(warehouseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResWarehouseDTO getWarehouseById(int id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        return warehouseMapper.toDTO(warehouse);
    }

    @Override
    public ResWarehouseDTO createWarehouse(ResWarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseMapper.toEntity(warehouseDTO);
        warehouse = warehouseRepository.save(warehouse);
        return warehouseMapper.toDTO(warehouse);
    }

    @Override
    public ResWarehouseDTO updateWarehouse(int id, ResWarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouse.setName(warehouseDTO.getName());
        warehouse.setLocation(warehouseDTO.getLocation());
        warehouse.setDescription(warehouseDTO.getDescription());
        warehouse.setUpdatedAt(warehouseDTO.getUpdatedAt());
        warehouse = warehouseRepository.save(warehouse);
        return warehouseMapper.toDTO(warehouse);
    }

    @Override
    public void deleteWarehouse(int id) {
        warehouseRepository.deleteById(id);
    }
}
