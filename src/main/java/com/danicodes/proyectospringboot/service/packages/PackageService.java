package com.danicodes.proyectospringboot.service.packages;

import com.danicodes.proyectospringboot.domain.packages.Package;
import java.util.List;
import java.util.UUID;

public interface PackageService {
    List<Package> findAll();

    Package findByUuid(UUID packageUuid);

    Package save(Package myPackage);

    Package update(UUID packageUuid, Package myPackage);
}
