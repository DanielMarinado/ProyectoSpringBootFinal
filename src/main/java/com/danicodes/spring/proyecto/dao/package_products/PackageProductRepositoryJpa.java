package com.danicodes.spring.proyecto.dao.package_products;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PackageProductRepositoryJpa extends CrudRepository<PackageProduct, UUID> {
    List<PackageProduct> findAll();

    List<PackageProduct> findAllByCode(String code);

    List<PackageProduct> findAllBySku(String sku);

    Optional<PackageProduct> findByCode(String code);

    Optional<PackageProduct> findBySku(String sku);

}
