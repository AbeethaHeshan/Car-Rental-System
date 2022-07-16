package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.dto.VehicleDTO;
import lk.carRental.springBoot.entity.Gallery;
import lk.carRental.springBoot.repo.GalleryRepo;
import lk.carRental.springBoot.repo.VehicleRepo;
import lk.carRental.springBoot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepo vehicle;

    @Autowired
    GalleryRepo gallery;


    @Override
    public void save(VehicleDTO vehicle) {


    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(VehicleDTO vehicle) {

    }

    @Override
    public ArrayList<VehicleDTO> getAll() {
        return null;
    }

    @Override
    public VehicleDTO search(String id) {
        return null;
    }

    @Override
    public ArrayList<VehicleDTO> getAllAvailableVehicle() {
        return null;
    }
}



