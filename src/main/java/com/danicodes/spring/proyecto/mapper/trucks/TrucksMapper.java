package com.danicodes.spring.proyecto.mapper.trucks;

import com.danicodes.spring.proyecto.domain.trucks.Truck;
import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.dto.truck.response.TruckResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TrucksMapper {

    public void update(Truck truckSource, Truck truckTarget) {
        if (Objects.nonNull(truckSource.getCode())) {
            truckTarget.setCode(truckSource.getCode());
        }

        if (Objects.nonNull(truckSource.getEnabled())) {
            truckTarget.setEnabled(truckSource.getEnabled());
        }

        if (Objects.nonNull(truckSource.getMyPkg())) {
            truckTarget.setMyPkg(truckSource.getMyPkg());
        }
    }
    public TruckResponseDto toResponseDto(Truck truck) {
        if( truck == null){
            return null;
        }

        var truckResponseDto = new TruckResponseDto();

        if (Objects.nonNull(truck.getUuid())) {
            truckResponseDto.setUuid(truck.getUuid());
        }

        if (Objects.nonNull(truck.getCode())) {
            truckResponseDto.setCode(truck.getCode());
        }

        if (Objects.nonNull(truck.getEnabled())) {
            truckResponseDto.setEnabled(truck.getEnabled());
        }

//        if (Objects.nonNull(truck.getMyPkg())) {
//            truckResponseDto.setPkg(truck.getMyPkg());
//        }

        return truckResponseDto;
    }

    public TruckRequestDto toRequestDto(Truck truck) {
        if( truck == null){
            return null;
        }

        var truckRequestDto = new TruckRequestDto();

        if (Objects.nonNull(truck.getCode())) {
            truckRequestDto.setCode(truck.getCode());
        }

        if (Objects.nonNull(truck.getEnabled())) {
            truckRequestDto.setEnabled(truck.getEnabled());
        }

//        if (Objects.nonNull(truck.getMyPkg())) {
//            truckRequestDto.setPkg(truck.getMyPkg());
//        }

        return truckRequestDto;
    }

    public Truck requestToTruck(TruckRequestDto request) {

        if (request == null) {
            return null;
        }

        var truck = new Truck();

        if (Objects.nonNull(request.getCode())) {
            truck.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getEnabled())) {
            truck.setEnabled(request.getEnabled());
        }

        return truck;
    }

    public Truck responseToTruck(TruckResponseDto response) {

        if (response == null) {
            return null;
        }

        var truck = new Truck();

        if (Objects.nonNull(response.getUuid())) {
            truck.setUuid(response.getUuid());
        }

        if (Objects.nonNull(response.getCode())) {
            truck.setCode(response.getCode());
        }

        if (Objects.nonNull(response.getEnabled())) {
            truck.setEnabled(response.getEnabled());
        }

        return truck;
    }
}
