package com.danicodes.spring.proyecto.controller.packages;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.swagger.packages.PackagesSwagger;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/packages")
public class PackagesController implements PackagesSwagger {

    private final PackageService packageService;

    @GetMapping
    public List<PackageResponseDto> findAll() {
        return packageService.findAll();
    }
}
