package lk.carRental.springBoot.config;

import lk.carRental.springBoot.util.StorageProperties;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = "lk.carRental.springBoot")
public class WebAppConfig {

         @Bean
        public ModelMapper modelMapper(){
             return  new ModelMapper();
         }

}
