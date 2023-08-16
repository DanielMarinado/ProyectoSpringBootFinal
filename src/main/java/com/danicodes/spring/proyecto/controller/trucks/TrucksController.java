package com.danicodes.spring.proyecto.controller.trucks;

import com.danicodes.spring.proyecto.domain.trucks.Truck;
import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.dto.truck.response.TruckResponseDto;
import com.danicodes.spring.proyecto.service.truck.TruckService;
import com.danicodes.spring.proyecto.swagger.trucks.TrucksSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/trucks")
public class TrucksController implements TrucksSwagger {
    private final TruckService truckService;

    @GetMapping
    public List<TruckResponseDto> findAll() {
        return truckService.findAll();
    }

    @GetMapping("/{uuid}")
    public TruckResponseDto findById(@PathVariable UUID uuid) {
        return truckService.findByUuid(uuid);
    }

    @PostMapping
    public TruckResponseDto save(@Valid @RequestBody TruckRequestDto request) {
        return truckService.save(request);
    }

    @PutMapping("/{uuid}")
    public TruckResponseDto update(@PathVariable UUID uuid, @RequestBody TruckRequestDto truck){
        return truckService.update(uuid, truck);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        truckService.delete(uuid);
    }
}
