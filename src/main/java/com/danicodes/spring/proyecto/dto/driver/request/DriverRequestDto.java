package com.danicodes.spring.proyecto.dto.driver.request;

import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class DriverRequestDto {
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enabled;
    private TruckRequestDto truck;
}
