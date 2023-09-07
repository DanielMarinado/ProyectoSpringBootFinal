package com.danicodes.spring.proyecto.swagger.packagesProducts;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.dto.package_product.response.PackageProductResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Tag(name = "PackagesProducts", description = "API de PackagesProducts")
public interface PackagesProductsSwagger {
    @Operation(
            summary = "Listar Packages por DTO [PackageProductResponseDto]",
            description = "Endpoint que nos ayuda a listar todos los Packages de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageProduct.class), mediaType = "application/json") }
    )
    public List<PackageProductResponseDto> findAll();

    @Operation(
            summary = "Obtener Packages por Entity [PackageProduct])",
            description = "Endpoint que nos ayuda a listar todos los packages de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageProduct.class), mediaType = "application/json") }
    )
    public List<PackageProduct> findAllPackage();

    @Operation(
            summary = "Busca un PackageProduct",
            description = "Endpoint que nos busca un packageProduct por UUID"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageProduct.class), mediaType = "application/json") }
    )
    public PackageProductResponseDto findById(@PathVariable UUID uuid);

    @Operation(
            summary = "Eliminar PackageProduct",
            description = "Endpoint que nos ayuda a eliminar un packageProduct sólo si el paquete se encuentra en estado LOADED."
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageProduct.class), mediaType = "application/json") }
    )
    public ResponseEntity<String> deleteProduct(@PathVariable UUID uuid);

}
