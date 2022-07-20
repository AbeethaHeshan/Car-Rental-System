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
    String status;
    @OneToMany(mappedBy="vehicle")
    private List<Gallery> galleries;

    public Vehicle(String id) {
        this.registrationNo = id;
    }
}
