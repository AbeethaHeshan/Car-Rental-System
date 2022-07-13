package lk.carRental.springBoot.service;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.entity.Customer;
import lk.carRental.springBoot.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;

    public void registerCustomer(CustomerDTO customerDTO){
           System.out.println("-----Save-----");
           customerRepo.save(mapper.map(customerDTO, Customer.class));

    }
}
