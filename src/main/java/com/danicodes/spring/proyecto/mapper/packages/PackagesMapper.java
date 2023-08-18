package com.danicodes.spring.proyecto.mapper.packages;

import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.packages.response.PackageResponseDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PackagesMapper {

    public void update(Package pkgSource, Package pkgTarget) {
        if (Objects.nonNull(pkgSource.getCode())) {
            pkgTarget.setCode(pkgSource.getCode());
        }

        if (Objects.nonNull(pkgSource.getWeight())) {
            pkgTarget.setWeight(pkgSource.getWeight());
        }

        if (Objects.nonNull(pkgSource.getSchedule())) {
            pkgTarget.setSchedule(pkgSource.getSchedule());
        }

        if (Objects.nonNull(pkgSource.getStatus())) {
            pkgTarget.setStatus(pkgSource.getStatus());
        }

        if (Objects.nonNull(pkgSource.getIs_deleted())) {
            pkgTarget.setIs_deleted(pkgSource.getIs_deleted());
        }

        if (Objects.nonNull(pkgSource.getDeleted_at())) {
            pkgTarget.setDeleted_at(pkgSource.getDeleted_at());
        }
    }
    public PackageResponseDto toResponseDto(Package pkg) {
        if( pkg == null){
            return null;
        }

        var packageResponseDto = new PackageResponseDto();

        if (Objects.nonNull(pkg.getUuid())) {
            packageResponseDto.setUuid(pkg.getUuid());
        }

        if (Objects.nonNull(pkg.getCode())) {
            packageResponseDto.setCode(pkg.getCode());
        }

        if (Objects.nonNull(pkg.getWeight())) {
            packageResponseDto.setWeight(pkg.getWeight());
        }

        if (Objects.nonNull(pkg.getSchedule())) {
            packageResponseDto.setSchedule(pkg.getSchedule());
        }

        if (Objects.nonNull(pkg.getStatus())) {
            packageResponseDto.setStatus(pkg.getStatus());
        }

        return packageResponseDto;
    }

    public Package requestToPackage(PackageRequestDto request) {

        if (request == null) {
            return null;
        }

        var aPackage = new Package();

        if (Objects.nonNull(request.getCode())) {
            aPackage.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getWeight())) {
            aPackage.setWeight(request.getWeight());
        }

        if (Objects.nonNull(request.getSchedule())) {
            aPackage.setSchedule(request.getSchedule());
        }

        if (Objects.nonNull(request.getStatus())) {
            aPackage.setStatus(request.getStatus());
        }

        return aPackage;
    }

    public Package responseToPackage(PackageResponseDto response) {

        if (response == null) {
            return null;
        }

        var aPackage = new Package();

        if (Objects.nonNull(response.getUuid())) {
            aPackage.setUuid(response.getUuid());
        }

        if (Objects.nonNull(response.getCode())) {
            aPackage.setCode(response.getCode());
        }

        if (Objects.nonNull(response.getWeight())) {
            aPackage.setWeight(response.getWeight());
        }

        if (Objects.nonNull(response.getSchedule())) {
            aPackage.setSchedule(response.getSchedule());
        }

        if (Objects.nonNull(response.getStatus())) {
            aPackage.setStatus(response.getStatus());
        }

        return aPackage;
    }
}
