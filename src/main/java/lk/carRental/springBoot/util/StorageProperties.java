package lk.carRental.springBoot.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.io.File;


@ConfigurationProperties("util")
public class StorageProperties {



    private String location = "src/main/java/lk/carRental/springBoot/assets";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
