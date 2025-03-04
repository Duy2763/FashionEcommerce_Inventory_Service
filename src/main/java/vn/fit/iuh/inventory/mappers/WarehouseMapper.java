package vn.fit.iuh.inventory.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.fit.iuh.inventory.entities.Warehouse;
import vn.fit.iuh.inventory.entities.response.ResWarehouseDTO;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    @Mapping(source = "inventories", target = "inventories")
    ResWarehouseDTO toDTO(Warehouse warehouse);
    Warehouse toEntity(ResWarehouseDTO warehouseDTO);
}
