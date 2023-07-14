package com.danicodes.proyectospringboot.dao.packages;

import com.danicodes.proyectospringboot.domain.packages.Package;
import com.danicodes.proyectospringboot.domain.packages.enums.StatusPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PackageRepositoryJpa extends CrudRepository<Package, UUID> {
    List<Package> findAll();

    List<Package> findAllByCode(String code);

    List<Package> findAllByStatus(StatusPackage status);

    Optional<Package> findByCode(String code);

    Optional<Package> findByStatus(StatusPackage status);

}
