package com.danicodes.spring.proyecto.service.driver.impl;

import com.danicodes.spring.proyecto.dao.drivers.DriverRepositoryJpa;
import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;
import com.danicodes.spring.proyecto.mapper.drivers.DriversMapper;
import com.danicodes.spring.proyecto.service.driver.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private DriverRepositoryJpa driverRepositoryJpa;
    private DriversMapper driverMapper;

    @Override
    public List<DriverResponseDto> findAll() {

        return driverRepositoryJpa
                .findAll()
                .stream()
                .map( driver -> driverMapper.toResponseDto(driver))
                .toList();
    }

    @Override
    public DriverResponseDto findByName(String name) {

        var person = driverRepositoryJpa.findByName(name)
                .orElseThrow(() -> new IllegalStateException(""));

        return driverMapper.toResponseDto(person);
    }

    @Override
    public DriverResponseDto findByUuid(UUID driverUuid) {
        return driverMapper.toResponseDto(findById(driverUuid));
    }

    @Override
    public DriverResponseDto save(Driver driver) {
        return driverMapper
                .toResponseDto(driverRepositoryJpa.save(driver));
    }

    @Override
    public DriverResponseDto update(UUID driverUuid, Driver driver) {
        var driverFound = findById(driverUuid);

        driverMapper.update(driver, driverFound);

        return driverMapper.toResponseDto(driverRepositoryJpa.save(driverFound));
    }

    public void delete(UUID driverUuid) {
        var driverFound = findById(driverUuid);
        driverRepositoryJpa.delete(driverFound);
    }
    private Driver findById(UUID driverUuid) {
        return driverRepositoryJpa.findById(driverUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }
}
