package com.danicodes.spring.proyecto.controller.packagesProducts;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.dto.package_product.response.PackageProductResponseDto;
import com.danicodes.spring.proyecto.service.package_product.PackageProductService;
import com.danicodes.spring.proyecto.swagger.packagesProducts.PackagesProductsSwagger;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages-products")
public class PackagesProductsController implements PackagesProductsSwagger {
    private final PackageProductService packageProductService;

    @GetMapping
    public List<PackageProductResponseDto> findAll() {
        return packageProductService.findAll();
    }

    @GetMapping("/packages")
    public List<PackageProduct> findAllPackage() {
        return packageProductService.findAllPackageProduct();
    }

    @GetMapping("/{uuid}")
    public PackageProductResponseDto findById(@PathVariable UUID uuid) {
        return packageProductService.findByUuid(uuid);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID uuid) {
        boolean error = packageProductService.delete(uuid);

        if(error) return ResponseEntity.status(HttpStatus.CONFLICT).body("El producto no se puede eliminar, ya que el paquete que lo contiene es distinto a LOADED");
        else return ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado el registro.");
    }

    /*
        @GetMapping("/packagesonly")
        public List<Package> findAllPackagesOnly() {
            return packageService.findAllPackage();
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
    */
}
