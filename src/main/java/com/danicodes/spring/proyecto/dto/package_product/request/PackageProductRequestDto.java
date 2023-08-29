package com.danicodes.spring.proyecto.dto.package_product.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PackageProductRequestDto {
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
    private Boolean is_deleted;
    private LocalDateTime deleted_at;
}
