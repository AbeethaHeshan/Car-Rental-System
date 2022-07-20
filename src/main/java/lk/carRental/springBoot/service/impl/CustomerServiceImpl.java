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

import javax.persistence.criteria.CriteriaBuilder;
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
    public String saveDetails(CustomerDTO customerDTO) {

         // save all data
         customer.save(mapper.map(customerDTO,Customer.class));

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
    public String delete(int id) {

        //customer.deleteById(id);
        return "";
    }

    @Override
    public CustomerDTO search(String id) {
        return mapper.map(customer.findByIdPath(Integer.parseInt(id)),CustomerDTO.class);
    }

    @Override
    public String IsVerified(int id) {
        return  customer.getCustomerIsVerified(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() {
        return mapper.map(customer.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public void updatePath(String path, int parseInt ,String... fileNames) {
           String nicFront = "";
           String nicBack = "";
           String lisFront = "";
           String lisBack = "";
           int c = 1;
           for (String file:fileNames) {

               switch (c){
                   case 1: nicFront = file;break;
                   case 2: nicBack =  file;break;
                   case 3: lisFront = file;break;
                   case 4: lisBack =  file;break;
                   default:
                       System.out.println("a");

               }

               c++;
        }
         System.out.println(nicFront+"qwer");
        Customer customer = this.customer.getCustomerByCustomerId(parseInt);
        System.out.println("Npp");
        this.customer.save(new Customer(parseInt,customer.getName(),customer.getAddress(),customer.getNic(),nicFront,nicBack,lisFront,lisBack,path,customer.getTel(),customer.getEmail(),customer.getStatus(),customer.getUserName(),customer.getPassword()));

    }

    @Override
    public String getPath(int parseInt) {
        return  customer.findByIdPath(parseInt);
    }

    @Override
    public CustomerDTO getFileName(int parseInt) {
        Customer fileNames = customer.getFileNames(parseInt);

        return mapper.map(fileNames,CustomerDTO.class);
    }

    @Override
    public void setNicNull(int parseInt) {
             customer.setNicPicNull(parseInt,"notVerified");
    }

    @Override
    public void setLisNull(int parseInt) {
           customer.setLisPicNull(parseInt,"notVerified");
    }

    @Override
    public void setCustomerStatusVerify(int parseInt) {
            customer.setCustomerVerified(parseInt,"verified");
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
