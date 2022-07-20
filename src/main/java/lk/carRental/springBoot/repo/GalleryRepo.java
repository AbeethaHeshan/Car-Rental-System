package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.dto.GalleryDTO;
import lk.carRental.springBoot.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface GalleryRepo extends JpaRepository<Gallery,String> {

}
