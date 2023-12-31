package com.danicodes.spring.proyecto.service.package_product.impl;

import com.danicodes.spring.proyecto.dao.package_products.PackageProductRepositoryJpa;
import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import com.danicodes.spring.proyecto.dto.package_product.request.PackageProductRequestDto;
import com.danicodes.spring.proyecto.dto.package_product.response.PackageProductResponseDto;
import com.danicodes.spring.proyecto.mapper.packagesProducts.PackagesProductsMapper;
import com.danicodes.spring.proyecto.service.package_product.PackageProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PackageProductServiceImpl implements PackageProductService {

    private PackageProductRepositoryJpa packageProductRepositoryJpa;
    private PackagesProductsMapper packagesProductsMapper;

    private PackageProductRepositoryJpa productRepositoryJpa;

    @Override
    public List<PackageProductResponseDto> findAll() {
        return packageProductRepositoryJpa
                .findAll()
                .stream()
                .map(pkgProduct ->  packagesProductsMapper.toResponseDto(pkgProduct))
                .toList();
    }

    @Override
    public List<PackageProduct> findAllPackageProduct() {
        return packageProductRepositoryJpa.findAll().stream().toList();
    }

    @Override
    public PackageProductResponseDto findByUuid(UUID packageProductUuid) {
        var myPackageProduct = findById(packageProductUuid);
        return packagesProductsMapper.toResponseDto(myPackageProduct);
    }

    @Override
    public PackageProductResponseDto save(PackageProductRequestDto request) {
        var myPackageProduct = packagesProductsMapper.requestToPackageProduct(request);
        var myPackageProductSaved =  packageProductRepositoryJpa.save(myPackageProduct);

        return packagesProductsMapper.toResponseDto(myPackageProductSaved);
    }

    @Override
    public PackageProductResponseDto update(UUID packageProductUuid, PackageProductRequestDto request) {
        var aPackageProductFound = findById(packageProductUuid);
        var aPackageProduct =  packagesProductsMapper.requestToPackageProduct(request);

        packagesProductsMapper.update(aPackageProduct, aPackageProductFound);

        return packagesProductsMapper.toResponseDto(packageProductRepositoryJpa.save(aPackageProduct));
    }

    private PackageProduct findById(UUID packageProductUuid) {
        return packageProductRepositoryJpa.findById(packageProductUuid)
                .orElseThrow(() -> new IllegalStateException(""));
    }

    @Override
    public void addAllToPackage(Package myPkg, List<PackageProduct> products){
        products.forEach(product -> product.setMyPackage(myPkg));
        productRepositoryJpa.saveAll(products);
    }

    @Override
    public boolean delete(UUID uuid) {
        var packageProductFound = findById(uuid);
        if(packageProductFound.getMyPackage().getStatus() ==  StatusPackage.LOADED) {
            packageProductRepositoryJpa.delete(packageProductFound);
            return false;
        }
        else
            return true;
    }
}
