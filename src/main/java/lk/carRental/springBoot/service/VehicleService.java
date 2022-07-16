package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
     void save(VehicleDTO vehicle);
     void delete(String id);
     void update(VehicleDTO vehicle);
     ArrayList<VehicleDTO> getAll();
     VehicleDTO search(String id);
     ArrayList<VehicleDTO> getAllAvailableVehicle();
}
