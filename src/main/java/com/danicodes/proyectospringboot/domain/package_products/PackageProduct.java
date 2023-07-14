package com.danicodes.proyectospringboot.domain.package_products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class PackageProduct {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private Double weight;

    private String sku;

    private Integer quantity;

    private Boolean is_deleted;

    private LocalDateTime deleted_at;

}
