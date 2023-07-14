package com.danicodes.spring.proyecto.service.package_product;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import java.util.List;
import java.util.UUID;

public interface PackageProductService {
    List<PackageProduct> findAll();

    PackageProduct findByUuid(UUID packageProductUuid);

    PackageProduct save(PackageProduct packageProduct);

    PackageProduct update(UUID packageProductUuid, PackageProduct packageProduct);
}