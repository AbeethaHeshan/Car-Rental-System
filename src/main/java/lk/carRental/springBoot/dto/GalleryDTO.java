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

     String id;
     String fileName;
     byte[] img;

}
