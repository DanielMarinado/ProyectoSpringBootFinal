package com.danicodes.proyectospringboot.domain.packages;

import com.danicodes.proyectospringboot.domain.packages.enums.StatusPackage;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Package {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private Double weight;

    private LocalDateTime schedule;

    @Enumerated(EnumType.STRING)
    private StatusPackage statusPackage = StatusPackage.LOADED;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;

}
