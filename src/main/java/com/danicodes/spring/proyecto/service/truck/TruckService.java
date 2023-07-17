package com.danicodes.spring.proyecto.service.truck;

import com.danicodes.spring.proyecto.domain.trucks.Truck;
import java.util.List;
import java.util.UUID;

public interface TruckService {
    List<Truck> findAll();

    Truck findByUuid(UUID truckUuid);

    Truck findByCode(String code);

    Truck save(Truck truck);

    Truck update(UUID truckUuid, Truck truck);
}
