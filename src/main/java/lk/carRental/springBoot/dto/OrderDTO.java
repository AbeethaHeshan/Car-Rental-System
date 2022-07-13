package lk.carRental.springBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {

    String orderId;
    LocalDateTime date;
    LocalDateTime from;
    LocalDateTime to;
    double totalCost;
    String status;

}
