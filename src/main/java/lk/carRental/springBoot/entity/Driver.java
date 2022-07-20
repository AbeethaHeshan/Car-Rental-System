package lk.carRental.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Driver {
    @Id
    private String driverId;
    private String name;
    private String address;
    private String nic;
    private String tell;
    private String nicFrontFileName;
    private String nicBackFileName;
    private String licenseFrontFileName;
    private String licenseBackFileName;
    private String path;
    private String status ;
    private String driverVerify ;


    @OneToOne(cascade = CascadeType.ALL)
    Vehicle vehicle;

}
