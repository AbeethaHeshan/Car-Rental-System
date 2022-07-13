package lk.carRental.springBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {

    private String orderId;
    private LocalDateTime date;
    private LocalDateTime from;
    private LocalDateTime to;
    private double totalCost;
    private String status;
    private CustomerDTO customer;
    private VehicleDTO vehicle;
    private PaymentDTO payment;

}
