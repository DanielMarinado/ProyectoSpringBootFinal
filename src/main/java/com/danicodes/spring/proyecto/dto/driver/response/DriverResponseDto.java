package com.danicodes.spring.proyecto.dto.driver.response;

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
    private Boolean enabled;
}
