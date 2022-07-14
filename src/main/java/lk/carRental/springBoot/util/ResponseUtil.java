package lk.carRental.springBoot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ResponseUtil {
   private int code;
   private String message;
   private Object data;

}
