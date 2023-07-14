package com.danicodes.proyectospringboot.service.truck.impl;

import com.danicodes.proyectospringboot.dao.trucks.TruckRepositoryJpa;
import com.danicodes.proyectospringboot.domain.trucks.Truck;
import com.danicodes.proyectospringboot.service.truck.TruckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TruckServiceImpl implements TruckService {

    private TruckRepositoryJpa truckRepositoryJpa;

    @Override
    public List<Truck> findAll() {
        return truckRepositoryJpa.findAll();
    }

    @Override
    public Truck findByUuid(UUID truckUuid) {
        return truckRepositoryJpa.findById(truckUuid).orElseThrow( () -> new IllegalStateException(""));
    }

    @Override
    public Truck save(Truck truck) {
        return truckRepositoryJpa.save(truck);
    }

    @Override
    public Truck update(UUID truckUuid, Truck truck) {
        var searchTruck = findByUuid(truckUuid);

        //
        //
        // FALTA EL MAPPER
        //
        //
        return truckRepositoryJpa.save(truck);
    }
}
