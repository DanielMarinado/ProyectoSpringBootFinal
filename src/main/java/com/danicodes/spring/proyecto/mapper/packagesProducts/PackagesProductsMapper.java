package com.danicodes.spring.proyecto.mapper.packagesProducts;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.package_product.request.PackageProductRequestDto;
import com.danicodes.spring.proyecto.dto.package_product.response.PackageProductResponseDto;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PackagesProductsMapper {

    public void update(PackageProduct pkgPrdSource, PackageProduct pkgPrdTarget) {
        if (Objects.nonNull(pkgPrdSource.getCode())) {
            pkgPrdTarget.setCode(pkgPrdSource.getCode());
        }

        if (Objects.nonNull(pkgPrdSource.getWeight())) {
            pkgPrdTarget.setWeight(pkgPrdSource.getWeight());
        }

        if (Objects.nonNull(pkgPrdSource.getSku())) {
            pkgPrdTarget.setSku(pkgPrdSource.getSku());
        }

        if (Objects.nonNull(pkgPrdSource.getQuantity())) {
            pkgPrdTarget.setQuantity(pkgPrdSource.getQuantity());
        }

        if (Objects.nonNull(pkgPrdSource.getIs_deleted())) {
            pkgPrdTarget.setIs_deleted(pkgPrdSource.getIs_deleted());
        }

        if (Objects.nonNull(pkgPrdSource.getDeleted_at())) {
            pkgPrdTarget.setDeleted_at(pkgPrdSource.getDeleted_at());
        }
    }
    public PackageProductResponseDto toResponseDto(PackageProduct pkgPrd) {
        if( pkgPrd == null){
            return null;
        }

        var packageProductResponseDto = new PackageProductResponseDto();

        if (Objects.nonNull(pkgPrd.getUuid())) {
            packageProductResponseDto.setUuid(pkgPrd.getUuid());
        }

        if (Objects.nonNull(pkgPrd.getCode())) {
            packageProductResponseDto.setCode(pkgPrd.getCode());
        }

        if (Objects.nonNull(pkgPrd.getWeight())) {
            packageProductResponseDto.setWeight(pkgPrd.getWeight());
        }

        if (Objects.nonNull(pkgPrd.getSku())) {
            packageProductResponseDto.setSku(pkgPrd.getSku());
        }

        if (Objects.nonNull(pkgPrd.getQuantity())) {
            packageProductResponseDto.setQuantity(pkgPrd.getQuantity());
        }

        return packageProductResponseDto;
    }

    public PackageProduct requestToPackageProduct(PackageProductRequestDto request) {

        if (request == null) {
            return null;
        }

        var aPackageProduct = new PackageProduct();

        if (Objects.nonNull(request.getCode())) {
            aPackageProduct.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getWeight())) {
            aPackageProduct.setWeight(request.getWeight());
        }

        if (Objects.nonNull(request.getSku())) {
            aPackageProduct.setSku(request.getSku());
        }

        if (Objects.nonNull(request.getQuantity())) {
            aPackageProduct.setQuantity(request.getQuantity());
        }

        return aPackageProduct;
    }

    public PackageProduct responseToPackageProduct(PackageProductResponseDto response) {

        if (response == null) {
            return null;
        }

        var aPackageProduct = new PackageProduct();

        if (Objects.nonNull(response.getUuid())) {
            aPackageProduct.setUuid(response.getUuid());
        }

        if (Objects.nonNull(response.getCode())) {
            aPackageProduct.setCode(response.getCode());
        }

        if (Objects.nonNull(response.getWeight())) {
            aPackageProduct.setWeight(response.getWeight());
        }

        if (Objects.nonNull(response.getSku())) {
            aPackageProduct.setSku(response.getSku());
        }

        if (Objects.nonNull(response.getQuantity())) {
            aPackageProduct.setQuantity(response.getQuantity());
        }

        return aPackageProduct;
    }
}
