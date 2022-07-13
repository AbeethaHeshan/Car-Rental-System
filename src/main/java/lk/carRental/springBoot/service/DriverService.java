package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {

    void save(DriverDTO driverDTO);
    void update(DriverDTO driverDTO);
    void delete(String id);
    DriverDTO search(String id);
    void IsVerified();
    ArrayList<DriverDTO> getAll();

}
