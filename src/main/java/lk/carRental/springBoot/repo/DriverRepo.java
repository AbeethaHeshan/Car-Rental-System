package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
