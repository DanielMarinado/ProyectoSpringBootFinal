package com.danicodes.proyectospringboot.domain.drivers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Driver {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private String name;

    private String cellphone;

    private Boolean enabled;

    private Boolean is_deleted;

    private LocalDateTime deleted_at;
}
