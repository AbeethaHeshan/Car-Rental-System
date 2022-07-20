package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.dto.CustomerDTO;
import lk.carRental.springBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Map;

public interface CustomerRepo extends JpaRepository<Customer,String> {


    @Query(value = "select MAX(customer_id)from customer", nativeQuery = true)
    int getLastCustomerId();

    @Query(value = "update customer set path=?1,nic_front=?3,nic_back=?4,license_front=?5,license_back=?6  where customer_id=?2" , nativeQuery = true)
    String updatePathById(String path,int id,String nicFront,String nicBack,String lisFront,String lisBack);

    @Query(value = "select path from  customer where customer_id=?1" , nativeQuery = true)
    String findByIdPath(int id);


    Customer getCustomerByCustomerId(int id);

    @Query(value = "select  nic_front,nic_back,license_front,license_back  from  customer where customer_id=?1" , nativeQuery = true)
    Customer getFileNames(int id);

    @Query(value = "update customer set license_front=null,license_back=null, status=?2 where customer_id =?1" , nativeQuery = true)
    void setNicPicNull(int id, String status);

    @Query(value = "update customer set nic_front=null,nic_back=null, status=?2 where customer_id =?1" , nativeQuery = true)
    void setLisPicNull(int id, String status);

    @Query(value = "update customer set status=?1 where customer_id=?2" , nativeQuery = true)
    void setCustomerVerified(int id,String status);

 @Query(value = "select status from  customer where customer_id=?1" , nativeQuery = true)
 String getCustomerIsVerified(int id);


}
