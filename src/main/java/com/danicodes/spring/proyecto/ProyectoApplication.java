package com.danicodes.spring.proyecto;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.mapper.drivers.DriversMapper;
import com.danicodes.spring.proyecto.mapper.trucks.TrucksMapper;
import com.danicodes.spring.proyecto.service.driver.DriverService;
import com.danicodes.spring.proyecto.service.package_product.PackageProductService;
import com.danicodes.spring.proyecto.service.packages.PackageService;
import com.danicodes.spring.proyecto.service.truck.TruckService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProyectoApplication  implements CommandLineRunner {

	@Autowired
	DriverService driverService;

	@Autowired
	DriversMapper driversMapper;

	@Autowired
	private PackageService packageService;

	@Autowired
	private PackageProductService packageProductService;

	@Autowired
	private TruckService truckService;
	@Autowired
	TrucksMapper trucksMapper;

	public static void main(String[] args) {

		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		/*

			Pruebas sólo para ver flujos

		 */


		//
		// DRIVERS 1
		//

		// INICIALIZAR DRIVER
		var driverRequestDto = new DriverRequestDto();
		driverRequestDto.setCode("007");
		driverRequestDto.setName("SuperDani");
		driverRequestDto.setCellphone("569 12312312");
		driverRequestDto.setEmail("driver1@elDriver.com");
		driverRequestDto.setEnabled(true);

		//GUARDAR DRIVER
		var driverResponseDto = driverService.save(driverRequestDto);

		//ENCONTRAR DRIVER
		var driver = driverService.findByName("SuperDani");

		// INICIALIZAR TRUCK
		var truckRequestDto = new TruckRequestDto();
		truckRequestDto.setCode("TRUCK007");
		truckRequestDto.setEnabled(true);

		// RELACIONAR TRUCK CON DRIVER
		//driverRequestDto.setTruck(truckRequestDto);
		truckService.addToDriver(driversMapper.responseToDriver(driver), truckRequestDto);

		// INICIALIZAR 2 PACKAGES
		var aPackage = new Package();
		aPackage.setCode("APACKAGE");
		aPackage.setWeight(30.0);
		aPackage.setSchedule(LocalDateTime.now());

		var aPackage2 = new Package();
		aPackage2.setCode("ANEWPACKAGE");
		aPackage2.setWeight(60.0);
		aPackage2.setSchedule(LocalDateTime.now());

		//ENCONTRAR TRUCK
		var aTruck = truckService.findByCode("TRUCK007");

		// RELACIONAR TRUCK CON PACKAGES Y GUARDARLOS
		truckService.addAllToTruck( trucksMapper.responseToTruck(aTruck), Arrays.asList(aPackage, aPackage2));




		// INICIALIZAR PACKAGE
		/*var myPackage = new Package();
		myPackage.setCode("PKG007");
		myPackage.setWeight(15.0);
		myPackage.setSchedule(LocalDateTime.now());
		packageService.save(myPackage);

		var packageRecent = packageService.findByCode("PKG007");*/

		// PACKAGE-PRODUCTS
		/*var packageProduct = new PackageProduct();
		packageProduct.setCode("PKG-PRD007");
		packageProduct.setWeight(30.0);
		packageProduct.setSku("#1256");
		packageProduct.setQuantity(2);
		packageProduct.setMyPackage(packageRecent);
		packageProductService.save(packageProduct);*/


		//var daniService = driverService.findAll();
		var depurationPoint = "depurationPoint";

	}
}
