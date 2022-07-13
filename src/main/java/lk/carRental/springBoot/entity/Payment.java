package lk.carRental.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Payment {

     @Id
     private  String id;
     @Column(unique = false, nullable = false, length = 100000)
     private byte[] bankSlip;
     private String status ;


}
