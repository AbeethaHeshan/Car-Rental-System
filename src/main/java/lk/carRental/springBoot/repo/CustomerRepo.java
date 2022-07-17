package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "select MAX(customer_id)from customer", nativeQuery = true)
    int getLastCustomerId();



}
