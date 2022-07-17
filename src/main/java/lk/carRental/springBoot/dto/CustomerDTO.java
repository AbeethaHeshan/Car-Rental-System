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

    private String customerId;
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

}
