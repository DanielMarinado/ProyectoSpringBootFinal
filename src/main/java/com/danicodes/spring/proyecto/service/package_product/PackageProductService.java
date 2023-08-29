package com.danicodes.spring.proyecto.service.package_product;

import com.danicodes.spring.proyecto.dto.package_product.request.PackageProductRequestDto;
import com.danicodes.spring.proyecto.dto.package_product.response.PackageProductResponseDto;

import java.util.List;
import java.util.UUID;

public interface PackageProductService {
    List<PackageProductResponseDto> findAll();

    PackageProductResponseDto findByUuid(UUID packageProductUuid);

    PackageProductResponseDto save(PackageProductRequestDto packageProduct);

    PackageProductResponseDto update(UUID packageProductUuid, PackageProductRequestDto packageProduct);

}
