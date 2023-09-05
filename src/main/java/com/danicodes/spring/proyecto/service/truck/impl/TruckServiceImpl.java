package com.danicodes.spring.proyecto.service.truck.impl;

import com.danicodes.spring.proyecto.dao.packages.PackageRepositoryJpa;
import com.danicodes.spring.proyecto.dao.trucks.TruckRepositoryJpa;
import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.dto.truck.response.TruckResponseDto;
import com.danicodes.spring.proyecto.mapper.trucks.TrucksMapper;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.service.truck.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TruckServiceImpl implements TruckService {

    private TruckRepositoryJpa truckRepositoryJpa;
    private PackageRepositoryJpa packageRepositoryJpa;
    private PackageService packageService;
    private TrucksMapper trucksMapper;

    @Override
    public List<TruckResponseDto> findAll() {
        return truckRepositoryJpa
                .findAll()
                .stream()
                .map(truck -> trucksMapper.toResponseDto(truck))
                .toList();
    }

    @Override
    public TruckResponseDto findByUuid(UUID truckUuid) {
        return trucksMapper.toResponseDto(findById(truckUuid));
    }

    @Override
    public TruckResponseDto findByCode(String code) {
        var truck = truckRepositoryJpa.findByCode(code).orElseThrow( ()-> new IllegalStateException(""));
        return trucksMapper.toResponseDto(truck);
    }

    @Override
    public TruckResponseDto save(TruckRequestDto request) {
        var truck = trucksMapper.requestToTruck(request);
        var truckSaved = truckRepositoryJpa.save(truck);

        //if(Objects.nonNull(request.getPkg())){
        //    addAllToTruck(truckSaved, request.getPkg());
        //}

        return trucksMapper.toResponseDto(truckSaved);
    }

    @Override
    public TruckResponseDto update(UUID truckUuid, TruckRequestDto request) {
        var truckFound = findById(truckUuid);
        var truck = trucksMapper.requestToTruck(request);

        trucksMapper.update(truck, truckFound);

        return trucksMapper.toResponseDto(truckRepositoryJpa.save(truckFound));
    }

    @Override
    public void delete(UUID truckUuid) {
        var truckFound = findById(truckUuid);
        truckRepositoryJpa.delete(truckFound);
    }

    private Truck findById(UUID truckUuid) {
        return truckRepositoryJpa.findById(truckUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }

    @Override
    public TruckResponseDto addToDriver(Driver driver, TruckRequestDto request) {

        var truckSaved = truckRepositoryJpa.save( request.toEntity(driver) );

        return trucksMapper.toResponseDto(truckSaved);
    }

    @Override
    public void addAllToTruck(Truck truck, List<Package> packages) {
        packages.forEach(pkg -> pkg.setTruck(truck));
        packageRepositoryJpa.saveAll(packages);
    }
}
