package lk.carRental.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Vehicle {

    @Id
    String registrationNo;
    String brand;
    String type;
    String passengers;
    String transmissionType;
    String fuelType;
    String colour;
    double dailyRate;
    double monthlyRate;
    double priceForExtraKM;
    String status = "Available";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    @OneToMany(mappedBy="vehicle")
    private List<Gallery> galleries;

}
