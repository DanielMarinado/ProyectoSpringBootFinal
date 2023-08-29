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
    public PackageResponseDto findByUuid(UUID packageUuid) {
        var myPackage = packageRepositoryJpa.findById(packageUuid).orElseThrow( () -> new IllegalStateException("") );
        return packagesMapper.toResponseDto(myPackage);
    }

    @Override
    public PackageResponseDto findByCode(String code) {
        var myPackage = packageRepositoryJpa.findByCode(code).orElseThrow( ()-> new IllegalStateException("") );
        return packagesMapper.toResponseDto(myPackage);
    }

    @Override
    public PackageResponseDto save(PackageRequestDto myPackage) {
        var aPackage = packagesMapper.requestToPackage(myPackage);
        var aPackageSaved = packageRepositoryJpa.save(aPackage);

        /*
        if(Objects.nonNull(request.getPackagesProductsssss())){
            addAllToPackage(aPackageSaved, request.getPackagesProductsssss());
        }
        */

        return packagesMapper.toResponseDto(aPackageSaved);
    }

    @Override
    public PackageResponseDto update(UUID packageUuid, PackageRequestDto myPackage) {
        var aPackageFound = findById(packageUuid);
        var aPackage = packagesMapper.requestToPackage(myPackage);

        packagesMapper.update(aPackage, aPackageFound);

        return packagesMapper.toResponseDto(packageRepositoryJpa.save(aPackage));
    }

    private Package findById(UUID packageUuid) {
        return packageRepositoryJpa.findById(packageUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }



    //@Override
    //public PackageResponseDto addToTruck(Truck truck, PackageRequestDto request) {

      //  var packages = packageRepositoryJpa.save( request.toEntity(truck) );

        //return packa.toResponseDto(truckSaved);
    //}
}
