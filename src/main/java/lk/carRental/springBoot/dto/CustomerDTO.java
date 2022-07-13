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
    private byte[] nicFront;
    private byte[] nicBack;
    private byte[] licenseFront;
    private byte[] licenseBack;
    private String tel;
    private String email;
    private String status;
    private String userName;
    private String password;

}
