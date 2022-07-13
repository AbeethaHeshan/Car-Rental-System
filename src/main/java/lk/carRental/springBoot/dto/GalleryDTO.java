package lk.carRental.springBoot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class GalleryDTO {

     private String id;
     private String fileName;
     private byte[] img;

}
