package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.entity.Customer;

import java.util.ArrayList;

public interface CustomerService {

           void save(CustomerDTO customerDTO);
           void update(CustomerDTO customerDTO);
           void delete(String id);
           CustomerDTO search(String id);
           void IsVerified();
           ArrayList<CustomerDTO> getAll();
           CustomerDTO search();
}
