package com.danicodes.spring.proyecto.swagger.packages;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

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
}
