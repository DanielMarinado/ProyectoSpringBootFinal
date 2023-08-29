package com.danicodes.spring.proyecto.dto.packages.response;

import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PackageResponseDto {
    private UUID uuid;
    private String code;
    private Double weight;
    private LocalDateTime schedule;
    private StatusPackage status;
}
