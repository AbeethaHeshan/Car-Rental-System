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
    List<GalleryDTO> galleryDTO;
}
