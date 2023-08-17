package com.danicodes.spring.proyecto.service.driver;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    List<DriverResponseDto> findAll();

    DriverResponseDto findByName(String name);

    DriverResponseDto findByUuid(UUID driverUuid);

    DriverResponseDto save(DriverRequestDto driver);

    DriverResponseDto update(UUID driverUuid, DriverRequestDto driver);

    void delete(UUID driverUuid);
}
