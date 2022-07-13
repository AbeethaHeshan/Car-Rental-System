package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

}
