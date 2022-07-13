package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.dto.DriverDTO;
import lk.carRental.springBoot.repo.DriverRepo;
import lk.carRental.springBoot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driver;

    @Override
    public void save(DriverDTO driverDTO) {

    }

    @Override
    public void update(DriverDTO driverDTO) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public DriverDTO search(String id) {
        return null;
    }

    @Override
    public void IsVerified() {

    }

    @Override
    public ArrayList<DriverDTO> getAll() {
        return null;
    }
}
