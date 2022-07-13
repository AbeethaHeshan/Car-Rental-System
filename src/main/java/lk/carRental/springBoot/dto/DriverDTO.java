package lk.carRental.springBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {

    private String  driverId;
    private String name;
    private String address;
    private String nic;
    private String tell;
    private byte[] nicFront;
    private byte[] nicBack;
    private byte[] licenseFront;
    private byte[] licenseBack;
    private String status;
    private String driverVerify;
    private VehicleDTO vehicle;
}
