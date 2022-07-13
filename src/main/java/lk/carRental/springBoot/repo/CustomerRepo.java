package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
