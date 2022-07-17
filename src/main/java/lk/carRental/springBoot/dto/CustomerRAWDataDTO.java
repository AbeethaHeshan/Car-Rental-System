package lk.carRental.springBoot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CustomerRAWDataDTO {
    private String customerId;
    private String name;
    private String address;
    private String nic;
    private String tel;
    private String email;
    private String status;
    private String userName;
    private String password;

}
