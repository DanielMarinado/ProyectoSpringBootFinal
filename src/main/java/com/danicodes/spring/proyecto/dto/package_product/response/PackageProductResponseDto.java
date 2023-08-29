package com.danicodes.spring.proyecto.dto.package_product.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PackageProductResponseDto {
    private UUID uuid;
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
    private Boolean is_deleted;
    private LocalDateTime deleted_at;
}
