package com.danicodes.spring.proyecto.dao.trucks;

import com.danicodes.spring.proyecto.domain.trucks.Truck;
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
