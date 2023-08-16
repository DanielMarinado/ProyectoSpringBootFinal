package com.danicodes.spring.proyecto.dto.truck.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class TruckRequestDto {
    private UUID uuid;

    private String code;

    private Boolean enabled;
}
