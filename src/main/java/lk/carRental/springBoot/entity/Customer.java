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
    private int customerId;
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


    public Customer(String nicFront, String nicBack, String licenseFront, String licenseBack) {
        this.nicFront = nicFront;
        this.nicBack = nicBack;
        this.licenseFront = licenseFront;
        this.licenseBack = licenseBack;
    }

    public Customer(int parseInt, String nicFront, String nicBack, String lisFront, String lisBack, String path) {

        customerId = parseInt;
        this.nicFront = nicFront;
        this.nicBack = nicBack;
        this.licenseFront = lisFront;
        this.licenseBack = lisBack;
        this.path = path;
    }
}
