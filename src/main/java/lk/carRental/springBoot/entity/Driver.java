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
    String driverId;
    String name;
    String address;
    String nic;
    String tell;
    @Column(unique = false, nullable = false, length = 100000)
    private byte[] photoNic;
    @Column(unique = false, nullable = false, length = 100000)
    private byte[] photoLicersence;
    String status = "Available";
    String driverVerify = "NotVerified";


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    Order order;

}
