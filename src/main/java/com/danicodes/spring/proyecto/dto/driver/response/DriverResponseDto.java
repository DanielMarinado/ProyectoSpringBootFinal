package com.danicodes.spring.proyecto.dto.driver.response;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class DriverResponseDto {
    private UUID uuid;
    private String code;
    private String name;
    private String cellphone;
    private String email;
}
