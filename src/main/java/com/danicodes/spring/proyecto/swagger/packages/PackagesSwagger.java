package com.danicodes.spring.proyecto.swagger.packages;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Tag(name = "Packages", description = "API de Packages")
public interface PackagesSwagger {
    @Operation(
            summary = "Listar Packages",
            description = "Endpoint que nos ayuda a listar todos los Packages de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public List<PackageResponseDto> findAll();

    @Operation(
            summary = "Obtener Package por UUID",
            description = "Endpoint que nos ayuda a buscar un package de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public PackageResponseDto findById(@PathVariable UUID uuid);

    @Operation(
            summary = "Guardar Package y PackagesProducts asociados",
            description = "Endpoint que nos ayuda a guardar un package y sus respectivos PackagesProducts de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public PackageResponseDto save( @Valid @RequestBody PackageRequestDto request );

    @Operation(
            summary = "Actualizar estado de un Package ",
            description = "Endpoint que nos ayuda a guardar un package y sus respectivos PackagesProducts de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = Package.class), mediaType = "application/json") }
    )
    public PackageResponseDto updateStatus(@PathVariable UUID uuid, @RequestBody PackageResponseDto packageResponseDto);
}
