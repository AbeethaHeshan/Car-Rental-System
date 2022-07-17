package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.CustomerRAWDataDTO;
import lk.carRental.springBoot.entity.Customer;

import java.util.ArrayList;

public interface CustomerService {

           int getLastId();
           String saveDetails(CustomerRAWDataDTO customerDTO);
           void savePhotos(CustomerDTO customerDTO);
           String update(CustomerDTO customerDTO);
           String delete(String id);
           CustomerDTO search(String id);
           boolean IsVerified(String id);
           ArrayList<CustomerDTO> getAll();

}
