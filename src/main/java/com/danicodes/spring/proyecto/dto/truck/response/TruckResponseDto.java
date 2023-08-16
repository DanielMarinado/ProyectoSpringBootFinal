package com.danicodes.spring.proyecto.dto.truck.response;

import com.danicodes.spring.proyecto.domain.trucks.Truck;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@ToString
public class TruckResponseDto {
    private UUID uuid;

    private String code;

    private Boolean enabled;
}
