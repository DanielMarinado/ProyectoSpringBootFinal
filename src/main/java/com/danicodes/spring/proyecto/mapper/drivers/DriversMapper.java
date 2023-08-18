package com.danicodes.spring.proyecto.mapper.drivers;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DriversMapper {

    public void update(Driver driverSource, Driver driverTarget) {
        if (Objects.nonNull(driverSource.getCode())) {
            driverTarget.setCode(driverSource.getCode());
        }

        if (Objects.nonNull(driverSource.getName())) {
            driverTarget.setName(driverSource.getName());
        }

        if (Objects.nonNull(driverSource.getCellphone())) {
            driverTarget.setCellphone(driverSource.getCellphone());
        }

        if (Objects.nonNull(driverSource.getEmail())) {
            driverTarget.setEmail(driverSource.getEmail());
        }

        if (Objects.nonNull(driverSource.getEnabled())) {
            driverTarget.setEnabled(driverSource.getEnabled());
        }

        if (Objects.nonNull(driverSource.getTruck())) {
            driverTarget.setTruck(driverSource.getTruck());
        }
    }
    public DriverResponseDto toResponseDto(Driver driver) {
        if( driver == null){
            return null;
        }

        var driverResponseDto = new DriverResponseDto();

        if (Objects.nonNull(driver.getUuid())) {
            driverResponseDto.setUuid(driver.getUuid());
        }

        if (Objects.nonNull(driver.getCode())) {
            driverResponseDto.setCode(driver.getCode());
        }

        if (Objects.nonNull(driver.getName())) {
            driverResponseDto.setName(driver.getName());
        }

        if (Objects.nonNull(driver.getCellphone())) {
            driverResponseDto.setCellphone(driver.getCellphone());
        }

        if (Objects.nonNull(driver.getEmail())) {
            driverResponseDto.setEmail(driver.getEmail());
        }

        if (Objects.nonNull(driver.getEnabled())) {
            driverResponseDto.setEnabled(driver.getEnabled());
        }

        return driverResponseDto;
    }

    public Driver requestToDriver(DriverRequestDto request) {

        if (request == null) {
            return null;
        }

        var driver = new Driver();

        if (Objects.nonNull(request.getCode())) {
            driver.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getName())) {
            driver.setName(request.getName());
        }

        if (Objects.nonNull(request.getCellphone())) {
            driver.setCellphone(request.getCellphone());
        }

        if (Objects.nonNull(request.getEmail())) {
            driver.setEmail(request.getEmail());
        }

        if (Objects.nonNull(request.getEnabled())) {
            driver.setEnabled(request.getEnabled());
        }

        return driver;
    }

    public Driver responseToDriver(DriverResponseDto response) {

        if (response == null) {
            return null;
        }

        var driver = new Driver();

        if (Objects.nonNull(response.getUuid())) {
            driver.setUuid(response.getUuid());
        }

        if (Objects.nonNull(response.getCode())) {
            driver.setCode(response.getCode());
        }

        if (Objects.nonNull(response.getName())) {
            driver.setName(response.getName());
        }

        if (Objects.nonNull(response.getCellphone())) {
            driver.setCellphone(response.getCellphone());
        }

        if (Objects.nonNull(response.getEmail())) {
            driver.setEmail(response.getEmail());
        }

        if (Objects.nonNull(response.getEnabled())) {
            driver.setEnabled(response.getEnabled());
        }

        return driver;
    }
}
