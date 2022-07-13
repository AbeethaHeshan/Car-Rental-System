package lk.carRental.springBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {

    private String registrationNo;
    private String brand;
    private String type;
    private String passengers;
    private String transmissionType;
    private String fuelType;
    private String colour;
    private double dailyRate;
    private double monthlyRate;
    private double priceForExtraKM;
    private String status;
    private List<GalleryDTO> gallery;
}
