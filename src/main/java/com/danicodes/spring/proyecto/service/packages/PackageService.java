package com.danicodes.spring.proyecto.service.packages;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;

import java.util.List;
import java.util.UUID;

public interface PackageService {
    List<PackageResponseDto> findAll();

    Package findByUuid(UUID packageUuid);

    Package findByCode(String code);

    Package save(Package myPackage);

    Package update(UUID packageUuid, Package myPackage);
}
