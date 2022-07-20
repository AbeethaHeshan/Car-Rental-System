package lk.carRental.springBoot.entity;

import lk.carRental.springBoot.dto.GalleryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Gallery {

       @Id
       @GeneratedValue(strategy= GenerationType.AUTO)
       long id;
       String path;
       String imgName;


       //one

       @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
       private Vehicle vehicle;


       public Gallery(String path, String imageName, Vehicle vehicle) {
                this.path = path;
                this.imgName = imageName;
                this.vehicle = vehicle;
       }
}
