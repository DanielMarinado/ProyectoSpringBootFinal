package com.danicodes.proyectospringboot.service.package_product.impl;

import com.danicodes.proyectospringboot.dao.package_products.PackageProductRepositoryJpa;
import com.danicodes.proyectospringboot.domain.package_products.PackageProduct;
import com.danicodes.proyectospringboot.service.package_product.PackageProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PackageProductServiceImpl implements PackageProductService {

    private PackageProductRepositoryJpa packageProductRepositoryJpa;

    @Override
    public List<PackageProduct> findAll() {
        return packageProductRepositoryJpa.findAll();
    }

    @Override
    public PackageProduct findByUuid(UUID packageProductUuid) {
        return packageProductRepositoryJpa.findById(packageProductUuid).orElseThrow( () -> new IllegalStateException("") );
    }

    @Override
    public PackageProduct save(PackageProduct packageProduct) {
        return packageProductRepositoryJpa.save(packageProduct);
    }

    @Override
    public PackageProduct update(UUID packageProductUuid, PackageProduct packageProduct) {
        var searchPackageProduct = findByUuid(packageProductUuid);

        //
        //
        // FALTA EL MAPPER
        //
        //

        return packageProductRepositoryJpa.save(packageProduct);
    }
}
