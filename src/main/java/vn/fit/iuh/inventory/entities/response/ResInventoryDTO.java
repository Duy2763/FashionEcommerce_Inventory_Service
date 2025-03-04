package vn.fit.iuh.inventory.entities.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ResInventoryDTO {
    private int inventoryId;
    private int productId;
    private int warehouseId;
    private int quantity;
    private String stockStatus;
    private LocalDateTime lastUpdated;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
