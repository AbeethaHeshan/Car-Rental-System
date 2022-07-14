package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.entity.Customer;
import lk.carRental.springBoot.repo.CustomerRepo;
import lk.carRental.springBoot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

         @Autowired
         CustomerRepo customer;


            @Override
            public String save(CustomerDTO customerDTO) {
                     return "";
            }

            @Override
            public String update(CustomerDTO customerDTO) {
                     return "";
            }

            @Override
            public String delete(String id) {
                     return "";
            }

            @Override
            public CustomerDTO search(String id) {
                return null;
            }

            @Override
            public boolean IsVerified(String id) {
                  return false;
            }

            @Override
            public ArrayList<CustomerDTO> getAll() {

               return null;
            }

            @Override
            public CustomerDTO search() {
                return null;
            }

 /*   @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    public void registerCustomer(CustomerDTO customerDTO){
           System.out.println("-----Save-----");
           customerRepo.save(mapper.map(customerDTO, Customer.class));

    }*/
}
