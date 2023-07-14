package com.danicodes.spring.proyecto.domain.packages;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@SQLDelete(sql = "UPDATE package SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
public class Package {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private Double weight;

    private LocalDateTime schedule;

    @Enumerated(EnumType.STRING)
    private StatusPackage status = StatusPackage.LOADED;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;


    @ManyToOne(fetch = FetchType.LAZY)
    private Truck truck;

    @OneToMany(mappedBy = "myPackage")
    private Set<PackageProduct> packageProducts;

}
