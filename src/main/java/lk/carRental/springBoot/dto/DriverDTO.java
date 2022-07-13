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

    String  driverId;
    String name;
    String address;
    String nic;
    String tell;
    private byte[] nicFront;
    private byte[] nicBack;
    private byte[] licenseFront;
    private byte[] licenseBack;
    String status;
    String driverVerify;
}
