package com.danicodes.spring.proyecto.dto.truck.request;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class TruckRequestDto {
    private String code;

    private Boolean enabled;
    //private List<Package> pkg;

    public Truck toEntity(Driver driver) {

        var truck = new Truck();
        truck.setCode(this.code);
        truck.setEnabled(this.enabled);
        truck.setDriver(driver);

        return truck;
    }
}
