package com.danicodes.spring.proyecto;

import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
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

@SpringBootApplication
public class ProyectoApplication  implements CommandLineRunner {

	@Autowired
	DriverService driverService;

	@Autowired
	private PackageService packageService;

	@Autowired
	private PackageProductService packageProductService;

	@Autowired
	private TruckService truckService;

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

		var driver = new Driver();
		driver.setCode("007");
		driver.setName("SuperDani");
		driver.setCellphone("569 12312312");
		driver.setEmail("driver1@elDriver.com");
		driver.setEnabled(true);
		driverService.save(driver);

		// DRIVER -> TRUCKS
		var truckDriver = new Truck();
		truckDriver.setCode("TRUCK007");
		truckDriver.setEnabled(true);
		truckDriver.setDriver(driver);
		truckService.save(truckDriver);

		// TRUCK -> PACKAGES
		var truckRecent = truckService.findByCode("TRUCK007");

		// PACKAGES
		var myPackage = new Package();
		myPackage.setCode("PKG007");
		myPackage.setWeight(15.0);
		myPackage.setSchedule(LocalDateTime.now());
		myPackage.setTruck(truckRecent);
		packageService.save(myPackage);

		var packageRecent = packageService.findByCode("PKG007");

		// PACKAGE-PRODUCTS
		var packageProduct = new PackageProduct();
		packageProduct.setCode("PKG-PRD007");
		packageProduct.setWeight(30.0);
		packageProduct.setSku("#1256");
		packageProduct.setQuantity(2);
		packageProduct.setMyPackage(packageRecent);
		packageProductService.save(packageProduct);


		var daniService = driverService.findAll();
		var depurationPoint = "depurationPoint";

	}
}
