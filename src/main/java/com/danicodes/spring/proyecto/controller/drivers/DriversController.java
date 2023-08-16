package com.danicodes.spring.proyecto.controller.drivers;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;
import com.danicodes.spring.proyecto.service.driver.DriverService;
import com.danicodes.spring.proyecto.swagger.drivers.DriversSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/drivers")
public class DriversController implements DriversSwagger {

    private final DriverService driverService;

    @GetMapping
    public List<DriverResponseDto> findAll() {

        return driverService.findAll();
    }

    @GetMapping("/{uuid}")
    public DriverResponseDto findById(@PathVariable UUID uuid) {

        return driverService.findByUuid(uuid);
    }

    @PostMapping
    public DriverResponseDto save(
            @Valid @RequestBody Driver request
    ) {

        return driverService.save(request);
    }

    @PutMapping("/{uuid}")
    public DriverResponseDto update(
            @PathVariable UUID uuid,
            @RequestBody Driver driver
    ) {

        return driverService.update(uuid, driver);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        driverService.delete(uuid);
    }
}
