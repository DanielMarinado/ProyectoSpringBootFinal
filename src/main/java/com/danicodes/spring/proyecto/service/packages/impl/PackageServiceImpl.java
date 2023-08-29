package com.danicodes.spring.proyecto.service.packages.impl;

import com.danicodes.spring.proyecto.dao.package_products.PackageProductRepositoryJpa;
import com.danicodes.spring.proyecto.dao.packages.PackageRepositoryJpa;
import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import com.danicodes.spring.proyecto.mapper.packages.PackagesMapper;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private PackageRepositoryJpa packageRepositoryJpa;
    private PackagesMapper packagesMapper;

    private PackageProductRepositoryJpa productRepositoryJpa;

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
        var myPackage = findById(packageUuid);
        return packagesMapper.toResponseDto(myPackage);
    }

    @Override
    public PackageResponseDto findByCode(String code) {
        var myPackage = packageRepositoryJpa.findByCode(code).orElseThrow( ()-> new IllegalStateException("") );
        return packagesMapper.toResponseDto(myPackage);
    }

    @Override
    public PackageResponseDto save(PackageRequestDto request) {
        var aPackage = packagesMapper.requestToPackage(request);
        var aPackageSaved = packageRepositoryJpa.save(aPackage);


        if(Objects.nonNull(request.getProducts())) {
            addAllToPackage(aPackageSaved, request.getProducts());
        }

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

    @Override
    public void addAllToPackage(Package myPkg, List<PackageProduct> products){
        products.forEach(product -> product.setMyPackage(myPkg));
        productRepositoryJpa.saveAll(products);
    }
}
