package lk.carRental.springBoot.service.impl;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.dto.CustomerRAWDataDTO;
import lk.carRental.springBoot.entity.Customer;
import lk.carRental.springBoot.repo.CustomerRepo;
import lk.carRental.springBoot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

         @Autowired
         CustomerRepo customer;

         @Autowired
         ModelMapper mapper;


    @Override
    public int getLastId() {
        return customer.getLastCustomerId();
    }

    @Override
            public String saveDetails(CustomerRAWDataDTO customerRDTO) {

                 // save all data
                 customer.save(mapper.map(customerRDTO,Customer.class));

                 //save  images

                 // if success return true

                 return "";
            }


            @Override
            public void savePhotos(CustomerDTO customerDTO) {

                customer.save(mapper.map(customerDTO,Customer.class));

            }



            @Override
            public String update(CustomerDTO customerDTO) {

                customer.save(mapper.map(customerDTO,Customer.class));
                return "";
            }

            @Override
            public String delete(String id) {

                customer.deleteById(id);
                return "";
            }

            @Override
            public CustomerDTO search(String id) {

                return mapper.map(customer.findById(id).get(),CustomerDTO.class);
            }

            @Override
            public boolean IsVerified(String id) {
                return false;
            }

            @Override
            public ArrayList<CustomerDTO> getAll() {
                return mapper.map(customer.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
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
