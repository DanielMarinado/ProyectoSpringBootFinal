package com.danicodes.proyectospringboot.dao.trucks;

import com.danicodes.proyectospringboot.domain.trucks.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TruckRepositoryJpa extends CrudRepository<Truck, UUID> {
    List<Truck> findAll();

    List<Truck> findAllByCode(String code);

    Optional<Truck> findByCode(String code);
}
