package vn.fit.iuh.inventory.entities.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
public class ResWarehouseDTO {
    private int warehouseId;
    private String name;
    private String location;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ResInventoryDTO> inventories;
}
