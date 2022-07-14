package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.entity.Customer;

import java.util.ArrayList;

public interface CustomerService {

           String save(CustomerDTO customerDTO);
           String update(CustomerDTO customerDTO);
           String delete(String id);
           CustomerDTO search(String id);
           boolean IsVerified(String id);
           ArrayList<CustomerDTO> getAll();
           CustomerDTO search();
}
