package com.danicodes.spring.proyecto.domain.package_products;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@SQLDelete(sql = "UPDATE package_product SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
public class PackageProduct {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private Double weight;

    private String sku;

    private Integer quantity;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MY_PACKAGE_UUID", nullable = false)
    private Package myPackage;


}
