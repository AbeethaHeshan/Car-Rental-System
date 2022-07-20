package lk.carRental.springBoot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {

    private int customerId;
    private String name;
    private String address;
    private String nic;
    private String nicFrontFileName;
    private String nicBackFileName;
    private String licenseFrontFileName;
    private String licenseBackFileName;
    private String tel;
    private String email;
    private String status;
    private String userName;
    private String password;

    public CustomerDTO(String nicFrontFileName, String nicBackFileName, String licenseFrontFileName, String licenseBackFileName) {
        this.nicFrontFileName = nicFrontFileName;
        this.nicBackFileName = nicBackFileName;
        this.licenseFrontFileName = licenseFrontFileName;
        this.licenseBackFileName = licenseBackFileName;
    }
}
