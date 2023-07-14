package com.danicodes.spring.proyecto.dao.drivers;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepositoryJpa extends CrudRepository<Driver, UUID> {
    List<Driver> findAll();

    List<Driver> findAllByName(String name);

    List<Driver> findAllByEmail(String email);

    List<Driver> findAllByCode(String code);

    Optional<Driver> findByName(String name);

    Optional<Driver> findByEmail(String email);

    Optional<Driver> findByCode(String code);
}
