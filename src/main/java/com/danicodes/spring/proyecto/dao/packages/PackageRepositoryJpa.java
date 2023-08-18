package com.danicodes.spring.proyecto.dao.packages;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.packages.enums.StatusPackage;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
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
