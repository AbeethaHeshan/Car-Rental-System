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
    @Column(unique = false, nullable = false, length = 100000)
    private byte[] nicFront;
    @Column(unique = false, nullable = false, length = 100000)
    private byte[] nicBack;
    @Column(unique = false, nullable = false, length = 100000)
    private byte[] licenseFront;
    @Column(unique = false, nullable = false, length = 100000)
    private byte[] licenseBack;
    private String tel;
    private String email;
    private String status;
    private String userName;
    private String password;





    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    Order order;

}
