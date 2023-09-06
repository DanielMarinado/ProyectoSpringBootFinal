package com.danicodes.spring.proyecto.service.package_product;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.package_product.request.PackageProductRequestDto;
import com.danicodes.spring.proyecto.dto.package_product.response.PackageProductResponseDto;

import java.util.List;
import java.util.UUID;

public interface PackageProductService {
    List<PackageProductResponseDto> findAll();
    List<PackageProduct> findAllPackageProduct();
    PackageProductResponseDto findByUuid(UUID packageProductUuid);

    PackageProductResponseDto save(PackageProductRequestDto packageProduct);

    PackageProductResponseDto update(UUID packageProductUuid, PackageProductRequestDto packageProduct);

    void addAllToPackage(Package myPkg, List<PackageProduct> products);

    boolean delete(UUID packageProductUuid);

}
