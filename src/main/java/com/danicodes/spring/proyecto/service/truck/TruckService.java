package com.danicodes.spring.proyecto.service.truck;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.dto.truck.response.TruckResponseDto;

import java.util.List;
import java.util.UUID;

public interface TruckService {
    List<TruckResponseDto> findAll();

    TruckResponseDto findByUuid(UUID truckUuid);

    TruckResponseDto findByCode(String code);

    TruckResponseDto save(TruckRequestDto truck);

    TruckResponseDto update(UUID truckUuid, TruckRequestDto truck);

    void delete(UUID truckUuid);

    TruckResponseDto addToDriver(Driver driver, TruckRequestDto request);

    public void addAllToTruck(Truck truck, List<Package> packages);
}
