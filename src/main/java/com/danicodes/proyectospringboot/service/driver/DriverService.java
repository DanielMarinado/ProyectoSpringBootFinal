package com.danicodes.proyectospringboot.service.driver;

import com.danicodes.proyectospringboot.domain.drivers.Driver;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    List<Driver> findAll();

    Driver findByUuid(UUID driverUuid);

    Driver save(Driver driver);

    Driver update(UUID driverUuid, Driver driver);
}
