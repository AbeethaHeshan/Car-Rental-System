package lk.carRental.springBoot.repo;

import lk.carRental.springBoot.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepo extends JpaRepository<Gallery,String> {
}
