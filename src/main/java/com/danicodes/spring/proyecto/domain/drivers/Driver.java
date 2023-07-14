package com.danicodes.spring.proyecto.domain.drivers;

import com.danicodes.spring.proyecto.domain.trucks.Truck;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@SQLDelete(sql = "UPDATE driver SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
public class Driver {
    @Id
    private UUID uuid = UUID.randomUUID();

    private String code;

    private String name;

    private String cellphone;

    private String email;

    private Boolean enabled;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;

    @OneToMany(mappedBy = "driver")
    private Set<Truck> trucks;
}
