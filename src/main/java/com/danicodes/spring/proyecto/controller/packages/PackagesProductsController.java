package com.danicodes.spring.proyecto.controller.packages;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import com.danicodes.spring.proyecto.service.package_product.PackageProductService;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.swagger.packages.PackagesSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages-products")
public class PackagesProductsController implements PackagesSwagger {

    private final PackageService packageService;
    private final PackageProductService packageProductService;


    @GetMapping
    public List<PackageResponseDto> findAll() {
        return packageService.findAll();
    }

    @GetMapping("/packagesonly")
    public List<Package> findAllPackagesOnly() {
        return packageService.findAllPackage();
    }

    @GetMapping("/packages")
    public List<PackageProduct> findAllPackage() {
        return packageProductService.findAllPackageProduct();
    }

    @GetMapping("/{uuid}")
    public PackageResponseDto findById(@PathVariable UUID uuid) {
        return packageService.findByUuid(uuid);
    }

    @PostMapping
    public PackageResponseDto save(
            @Valid @RequestBody PackageRequestDto request
    ) {
        return packageService.save(request);
    }

    @PutMapping("/{uuid}")
    public PackageResponseDto update(
            @PathVariable UUID uuid,
            @RequestBody PackageRequestDto pkg
    ) {

        return packageService.update(uuid, pkg);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        packageService.delete(uuid);
    }
}
