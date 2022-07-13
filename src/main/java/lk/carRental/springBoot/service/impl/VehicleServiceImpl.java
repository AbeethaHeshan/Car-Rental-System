package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.repo.GalleryRepo;
import lk.carRental.springBoot.repo.VehicleRepo;
import lk.carRental.springBoot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

                @Autowired
                GalleryRepo gallery;

                @Autowired
                VehicleRepo vehicle;

                @Override
                public void save() {

                }

                @Override
                public void delete() {

                }

                @Override
                public void update() {

                }

                @Override
                public void getAll() {

                }

                @Override
                public void search() {

                }

                @Override
                public void getAllAvailableVehicle() {

                }
}
