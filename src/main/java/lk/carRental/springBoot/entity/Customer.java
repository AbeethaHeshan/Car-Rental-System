package lk.carRental.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String address;
    private String nic;
    private String nicFront;
    private String nicBack;
    private String licenseFront;
    private String licenseBack;
    private String path;
    private String tel;
    private String email;
    private String status;
    private String userName;
    private String password;


}
