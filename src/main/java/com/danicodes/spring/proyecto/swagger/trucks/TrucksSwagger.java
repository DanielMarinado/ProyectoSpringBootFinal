package com.danicodes.spring.proyecto.swagger.trucks;

import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.dto.truck.response.TruckResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

@Tag(name = "Trucks", description = "API de Trucks")
public interface TrucksSwagger {
    @Operation(
            summary = "Listar Trucks",
            description = "Endpoint que nos ayuda a listar todos los Trucks de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }
    )
    public List<TruckResponseDto> findAll();

    @Operation(
            summary = "Buscar Truck",
            description = "Endpoint que nos ayuda encontrar un Truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
    })
    public TruckResponseDto findById(UUID uuid);

    @Operation(
            summary = "Guardar Truck",
            description = "Endpoint que nos ayuda guardar un Truck"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
    })
    public TruckResponseDto save(TruckRequestDto request);

    @Operation(
            summary = "Actualizar un Truck",
            description = "Endpoint que nos ayuda a actualizar un Truck por medio de su uuid y la informacion a modificar"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
    })
    public TruckResponseDto update(UUID uuid, TruckRequestDto request);

    @Operation(
            summary = "Eliminar un Truck",
            description = "Endpoint que nos ayuda a eliminar un Truck por medio de su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public void delete(UUID uuid);
}
