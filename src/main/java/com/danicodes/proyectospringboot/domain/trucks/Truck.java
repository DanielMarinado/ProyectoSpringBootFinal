package com.danicodes.proyectospringboot.domain.trucks;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@SQLDelete(sql = "UPDATE truck SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
public class Truck {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private Boolean enabled;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;
}
