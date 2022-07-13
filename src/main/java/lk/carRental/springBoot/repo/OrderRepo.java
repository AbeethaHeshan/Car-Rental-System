package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {
}
