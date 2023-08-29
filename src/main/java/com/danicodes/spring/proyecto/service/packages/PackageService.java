package com.danicodes.spring.proyecto.service.packages;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;

import java.util.List;
import java.util.UUID;

public interface PackageService {
    List<PackageResponseDto> findAll();

    PackageResponseDto findByUuid(UUID packageUuid);

    PackageResponseDto findByCode(String code);

    PackageResponseDto save(PackageRequestDto myPackage);

    PackageResponseDto update(UUID packageUuid, PackageRequestDto myPackage);
    void addAllToPackage(Package myPkg, List<PackageProduct> products);
}
