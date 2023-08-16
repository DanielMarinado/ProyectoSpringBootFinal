package com.danicodes.spring.proyecto.service.driver.impl;

import com.danicodes.spring.proyecto.dao.drivers.DriverRepositoryJpa;
import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.dto.driver.response.DriverResponseDto;
import com.danicodes.spring.proyecto.mapper.drivers.DriversMapper;
import com.danicodes.spring.proyecto.mock.drivers.DriversMock;
import com.danicodes.spring.proyecto.mock.drivers.DriversResponseDtoMock;
import com.danicodes.spring.proyecto.service.driver.DriverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {

    @Mock
    private DriverRepositoryJpa driverRepositoryJpa;

    @Mock
    private DriversMapper driversMapper;

    @InjectMocks
    private DriverServiceImpl service;

    @Test
    void findAll() {

        // Arrange - Given
        var responseDriverDto = DriversResponseDtoMock.build();
        when(driverRepositoryJpa.findAll()).thenReturn(singletonList(DriversMock.build()));
        when(driversMapper.toResponseDto(any())).thenReturn(responseDriverDto);

        // Act - When
        var response = service.findAll();

        // Assert - Then
        assertNotNull(response);
        assertEquals(responseDriverDto.getName(), response.get(0).getName());
    }

    @Test
    void findByName() {

        // Arrange - Given
        var responseDriverDto = DriversResponseDtoMock.build();
        when(driverRepositoryJpa.findByName(any())).thenReturn(Optional.of(DriversMock.build()));
        when(driversMapper.toResponseDto(any())).thenReturn(responseDriverDto);

        // Act - When
        var response = service.findByName("Jaime");

        // Assert - Then
        assertNotNull(response);
        assertEquals(responseDriverDto.getName(), response.getName());
    }
}