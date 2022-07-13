package lk.carRental.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Order{

    @Id
    String orderId ;
    LocalDateTime date;
    LocalDateTime from;
    LocalDateTime to;
    double totalCost;
    String status;
// more

    @OneToOne
    Vehicle vehicle;

    @OneToOne
    Payment payment;

    @OneToOne
    Customer customer;


}
