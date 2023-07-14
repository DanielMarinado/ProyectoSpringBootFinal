package com.danicodes.proyectospringboot.service.truck;

import com.danicodes.proyectospringboot.domain.trucks.Truck;
import java.util.List;
import java.util.UUID;

public interface TruckService {
    List<Truck> findAll();

    Truck findByUuid(UUID truckUuid);

    Truck save(Truck truck);

    Truck update(UUID truckUuid, Truck truck);
}
