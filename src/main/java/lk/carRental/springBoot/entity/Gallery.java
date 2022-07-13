package lk.carRental.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Gallery {

       @Id
       @GeneratedValue(strategy= GenerationType.AUTO)
       String id;
       String fileName;
       @Column(unique = false, nullable = false, length = 100000)
       private byte[] img;

       @ManyToOne
       @JoinColumn(name="registrationNo", nullable=false)
       private Vehicle vehicle;

}
