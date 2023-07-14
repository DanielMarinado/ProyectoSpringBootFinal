package com.danicodes.proyectospringboot.service.packages.impl;

import com.danicodes.proyectospringboot.dao.packages.PackageRepositoryJpa;
import com.danicodes.proyectospringboot.domain.packages.Package;
import com.danicodes.proyectospringboot.service.packages.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private PackageRepositoryJpa packageRepositoryJpa;

    @Override
    public List<Package> findAll() {
        return packageRepositoryJpa.findAll();
    }

    @Override
    public Package findByUuid(UUID packageUuid) {
        return packageRepositoryJpa.findById(packageUuid).orElseThrow( () -> new IllegalStateException("") );
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
}
