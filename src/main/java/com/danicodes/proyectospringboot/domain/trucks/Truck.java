package com.danicodes.proyectospringboot.domain.trucks;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Truck {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private Boolean enabled;

    private Boolean is_deleted;

    private LocalDateTime deleted_at;
}
