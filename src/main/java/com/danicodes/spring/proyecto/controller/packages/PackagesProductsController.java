package com.danicodes.spring.proyecto.controller.packages;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import com.danicodes.spring.proyecto.service.package_product.PackageProductService;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.swagger.packages.PackagesSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/product/{uuid}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID uuid) {
        boolean error = packageProductService.delete(uuid);

        if(error) return ResponseEntity.status(HttpStatus.CONFLICT).body("El producto no se puede eliminar, ya que el paquete que lo contiene es distinto a LOADED");
        else return ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado el registro.");
    }

    @PatchMapping("/{uuid}")
    public PackageResponseDto updateStatus(@PathVariable UUID uuid, @RequestBody PackageResponseDto packageResponseDto){
        return packageService.updateStatus(uuid, packageResponseDto);
    }
}
