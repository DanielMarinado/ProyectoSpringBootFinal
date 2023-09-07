package com.danicodes.spring.proyecto.service.driver.impl;

import com.danicodes.spring.proyecto.dao.drivers.DriverRepositoryJpa;
import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;
import com.danicodes.spring.proyecto.mapper.drivers.DriversMapper;
import com.danicodes.spring.proyecto.mapper.packages.PackagesMapper;
import com.danicodes.spring.proyecto.service.driver.DriverService;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.service.truck.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private DriverRepositoryJpa driverRepositoryJpa;
    private DriversMapper driverMapper;
    private PackageService packageService;

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
    public DriverResponseDto save(DriverRequestDto request) {
        var driverSaved = driverRepositoryJpa.save(driverMapper.requestToDriver(request));

        //if(Objects.nonNull(request.getTruck())){
        //    truckService.addToDriver(driverSaved, request.getTruck());
        //}
        return driverMapper
                .toResponseDto(driverSaved);
    }

    @Override
    public DriverResponseDto update(UUID driverUuid, DriverRequestDto request) {
        var driverFound = findById(driverUuid);
        var driver = driverMapper.requestToDriver(request);

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

    public String managedPackages(UUID driverUUID){
        var driver = findById(driverUUID);
        var truck = driver.getTruck();

        var packages = packageService.findAllPackage();
        List<Package> packagesAsociados = new ArrayList<>();

        for (Package pkg : packages){
            if( pkg.getTruck().getUuid() == truck.getUuid())
                packagesAsociados.add(pkg);
        }

        for(Package myPkg : packagesAsociados){
            if( !((myPkg.getStatus() == StatusPackage.DELIVERED) || (myPkg.getStatus() == StatusPackage.CANCELED)) ){
                return "Hay un(os) paquete(s) que no ha(n) sido gestionados.";
            }
        }

        //var packages = truck.getMyPkg();
        //if( packages.isEmpty() ) return "No contiene paquetes.";
        /*
        for (var myPkg : packages) {
            if( !((myPkg.getStatus() == StatusPackage.DELIVERED) || (myPkg.getStatus() == StatusPackage.CANCELED)) ){
                return "Hay un(os) paquete(s) que no ha(n) sido gestionados.";
            }
        }
        */

        return "Todos los paquetes están gestionados (DELIVERED - CANCELED)";
    }
}
