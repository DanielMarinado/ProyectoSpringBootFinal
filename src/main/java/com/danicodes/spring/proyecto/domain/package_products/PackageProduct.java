package com.danicodes.spring.proyecto.domain.package_products;

import com.danicodes.spring.proyecto.domain.packages.Package;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Package myPackage;

}
