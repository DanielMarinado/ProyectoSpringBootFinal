package com.danicodes.spring.proyecto.dto.packages.response;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PackageResponseDto {
    private UUID uuid;
    private String code;
    private Double weight;
    private LocalDateTime schedule;
    private StatusPackage status;
    private List<PackageProduct> products;
}
