package com.danicodes.spring.proyecto.controller.packages;

import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.swagger.packages.PackagesSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages")
public class PackagesController implements PackagesSwagger {

    private final PackageService packageService;

    @GetMapping
    public List<PackageResponseDto> findAll() {
        return packageService.findAll();
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

    @PatchMapping("/{uuid}")
    public PackageResponseDto updateStatus(@PathVariable UUID uuid, @RequestBody PackageResponseDto packageResponseDto){
        return packageService.updateStatus(uuid, packageResponseDto);
    }



    /*
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
