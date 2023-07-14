package com.danicodes.spring.proyecto.service.driver.impl;

import com.danicodes.spring.proyecto.dao.drivers.DriverRepositoryJpa;
import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.service.driver.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private DriverRepositoryJpa driverRepositoryJpa;

    @Override
    public List<Driver> findAll() {
        return driverRepositoryJpa.findAll();
    }

    @Override
    public Driver findByUuid(UUID driverUuid) {
        return driverRepositoryJpa.findById(driverUuid).orElseThrow( () -> new IllegalStateException("") );
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepositoryJpa.save(driver);
    }

    @Override
    public Driver update(UUID driverUuid, Driver driver) {
        var searchDriver = findByUuid(driverUuid);

        //
        //
        // FALTA EL MAPPER
        //
        //

        return driverRepositoryJpa.save(driver);
    }



}
