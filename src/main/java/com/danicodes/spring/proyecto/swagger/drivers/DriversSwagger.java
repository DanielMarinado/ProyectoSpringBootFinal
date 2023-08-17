package com.danicodes.spring.proyecto.swagger.drivers;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;
@Tag(name = "Drivers", description = "API de Drivers")
public interface DriversSwagger {
    @Operation(
            summary = "Listar Drivers",
            description = "Endpoint que nos ayuda a listar todos los Drivers de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }
    )
    public List<DriverResponseDto> findAll();
    @Operation(
            summary = "Buscar Driver",
            description = "Endpoint que nos ayuda encontrar un Driver por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
    })
    public DriverResponseDto findById(UUID uuid);
    @Operation(
            summary = "Guardar Driver",
            description = "Endpoint que nos ayuda guardar un Driver"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
    })
    public DriverResponseDto save(DriverRequestDto request);
    @Operation(
            summary = "Actualizar un Driver",
            description = "Endpoint que nos ayuda a actualizar un Driver por medio de su uuid y la informacion a modificar"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
    })
    public DriverResponseDto update(UUID uuid, DriverRequestDto driver);
    @Operation(
            summary = "Eliminar un Driver",
            description = "Endpoint que nos ayuda a eliminar un Driver por medio de su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public void delete(UUID uuid);
}
