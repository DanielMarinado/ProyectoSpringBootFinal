package com.danicodes.spring.proyecto;

import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.dto.driver.request.DriverRequestDto;
import com.danicodes.spring.proyecto.dto.package_product.request.PackageProductRequestDto;
import com.danicodes.spring.proyecto.dto.packages.request.PackageRequestDto;
import com.danicodes.spring.proyecto.dto.truck.request.TruckRequestDto;
import com.danicodes.spring.proyecto.mapper.drivers.DriversMapper;
import com.danicodes.spring.proyecto.mapper.packages.PackagesMapper;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		//var aPackage = new Package();
		//aPackage.setCode("APACKAGE");
		//aPackage.setWeight(30.0);
		//aPackage.setSchedule(LocalDateTime.now());

		//var aPackage2 = new Package();
		//aPackage2.setCode("ANEWPACKAGE");
		//aPackage2.setWeight(60.0);
		//aPackage2.setSchedule(LocalDateTime.now());

		//ENCONTRAR TRUCK
		var aTruck = truckService.findByCode("TRUCK007");

		// RELACIONAR TRUCK CON PACKAGES Y GUARDARLOS
		//truckService.addAllToTruck( trucksMapper.responseToTruck(aTruck), Arrays.asList(aPackage, aPackage2));


		//NEW
		// INICIALIZAR PACKAGES
		var aPackageDTO = new PackageRequestDto();
		aPackageDTO.setCode("APACKAGE22");
		aPackageDTO.setWeight(320.0);
		aPackageDTO.setSchedule(LocalDateTime.now());

		// Crear package-Product
		var aPackageProduct = new PackageProduct();
		aPackageProduct.setCode("PackageProductENTITIII");
		aPackageProduct.setWeight(30.30);
		aPackageProduct.setSku("333333");
		aPackageProduct.setQuantity(33);



		//aPackageDTO.setProducts(Stream.of(aPackageProduct).collect(Collectors.toSet()));
		//aPackageDTO.setProducts(Arrays.asList(aPackageProduct));

		//packageService.save(aPackageDTO);

		packageService.save(aPackageDTO);


		var aPackageFound =packageService.findAll().get(0);
		var packageMapper = new PackagesMapper();
		packageProductService.addAllToPackage(packageMapper.responseToPackage(aPackageFound), Arrays.asList(aPackageProduct));
		//packageService.addAllToPackage(packageMapper.responseToPackage(aPackageFound), Stream.of(aPackageProduct).collect(Collectors.toSet()));



		//END NEW

		// truck con packages por default (Funcionando OK)
//		var nuevoCamionRequest = new TruckRequestDto();
//		nuevoCamionRequest.setCode("CAMIONCODE");
//		nuevoCamionRequest.setEnabled(true);
//
//		var packageCamion = new Package();
//		packageCamion.setCode("PACKAGE-CODE");
//		packageCamion.setWeight(12.12);
//		packageCamion.setStatus(StatusPackage.LOADED);
//		packageCamion.setSchedule(LocalDateTime.now());
//
//		nuevoCamionRequest.setPkg(Arrays.asList(packageCamion));
//
//		truckService.save(nuevoCamionRequest);
		//Fin truck con packages por default.


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
