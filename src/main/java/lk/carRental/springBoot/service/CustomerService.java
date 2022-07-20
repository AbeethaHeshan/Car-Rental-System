package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.CustomerRAWDataDTO;
import lk.carRental.springBoot.entity.Customer;

import java.util.ArrayList;

public interface CustomerService {

           int getLastId();
           String saveDetails(CustomerDTO customerDTO);
           void savePhotos(CustomerDTO customerDTO);
           String update(CustomerDTO customerDTO);
           String delete(int id);
           CustomerDTO search(String id);
           String IsVerified(int id);
           ArrayList<CustomerDTO> getAll();

    void updatePath(String path, int parseInt,String... fileNames);

    String getPath(int parseInt);

    CustomerDTO getFileName(int parseInt);

    void setNicNull(int parseInt);

    void setLisNull(int parseInt);

    void setCustomerStatusVerify(int parseInt);
}
