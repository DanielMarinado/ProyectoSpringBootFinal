package com.danicodes.spring.proyecto.mock.drivers;

import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;

public class DriversResponseDtoMock {

    public static DriverResponseDto build() {
        var driversResponse = new DriverResponseDto();
        driversResponse.setName("SuperDani");

        return driversResponse;
    }
}
