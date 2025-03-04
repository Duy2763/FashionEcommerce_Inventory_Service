package vn.fit.iuh.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.fit.iuh.inventory.entities.Inventory;
import vn.fit.iuh.inventory.entities.response.ResInventoryDTO;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    @Mapping(source = "warehouse.warehouseId", target = "warehouseId")
    ResInventoryDTO toDTO(Inventory inventory);
    @Mapping(source = "warehouseId", target = "warehouse.warehouseId")
    Inventory toEntity(ResInventoryDTO inventoryDTO);
}
