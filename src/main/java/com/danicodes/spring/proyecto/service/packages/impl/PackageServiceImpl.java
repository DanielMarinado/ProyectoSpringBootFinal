package com.danicodes.spring.proyecto.service.packages.impl;

import com.danicodes.spring.proyecto.dao.packages.PackageRepositoryJpa;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import com.danicodes.spring.proyecto.mapper.packages.PackagesMapper;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private PackageRepositoryJpa packageRepositoryJpa;
    private PackagesMapper packagesMapper;

    @Override
    public List<PackageResponseDto> findAll() {
        return packageRepositoryJpa
                .findAll()
                .stream()
                .map(pkg -> packagesMapper.toResponseDto(pkg))
                .toList();
    }

    @Override
    public Package findByUuid(UUID packageUuid) {
        return packageRepositoryJpa.findById(packageUuid).orElseThrow( () -> new IllegalStateException("") );
    }

    @Override
    public Package findByCode(String code) {
        return packageRepositoryJpa.findByCode(code).orElseThrow( ()-> new IllegalStateException("") );
    }

    @Override
    public Package save(Package myPackage) {
        return packageRepositoryJpa.save(myPackage);
    }

    @Override
    public Package update(UUID packageUuid, Package myPackage) {
        var searchPackage = findByUuid(packageUuid);

        //
        //
        // FALTA EL MAPPER
        //
        //
        return packageRepositoryJpa.save(myPackage);
    }

    //@Override
    //public PackageResponseDto addToTruck(Truck truck, PackageRequestDto request) {

      //  var packages = packageRepositoryJpa.save( request.toEntity(truck) );

        //return packa.toResponseDto(truckSaved);
    //}
}
