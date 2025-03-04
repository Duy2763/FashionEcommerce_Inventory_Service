package vn.fit.iuh.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fit.iuh.inventory.entities.Warehouse;

@Repository
public interface WarehouseRepository  extends JpaRepository<Warehouse, Integer> {
}
