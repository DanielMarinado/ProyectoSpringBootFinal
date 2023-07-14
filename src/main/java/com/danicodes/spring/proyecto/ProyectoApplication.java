package com.danicodes.spring.proyecto;

import com.danicodes.spring.proyecto.dao.drivers.DriverRepositoryJpa;
import com.danicodes.spring.proyecto.dao.package_products.PackageProductRepositoryJpa;
import com.danicodes.spring.proyecto.dao.packages.PackageRepositoryJpa;
import com.danicodes.spring.proyecto.dao.trucks.TruckRepositoryJpa;
import com.danicodes.spring.proyecto.domain.drivers.Driver;
import com.danicodes.spring.proyecto.domain.package_products.PackageProduct;
import com.danicodes.spring.proyecto.domain.packages.Package;
import com.danicodes.spring.proyecto.domain.trucks.Truck;
import com.danicodes.spring.proyecto.service.driver.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProyectoApplication  implements CommandLineRunner {

	@Autowired
	DriverServiceImpl driverService;

	@Autowired
	private DriverRepositoryJpa driverRepositoryJpa;

	@Autowired
	private PackageRepositoryJpa packageRepositoryJpa;

	@Autowired
	private PackageProductRepositoryJpa packageProductRepositoryJpa;

	@Autowired
	private TruckRepositoryJpa truckRepositoryJpa;

	public static void main(String[] args) {

		SpringApplication.run(ProyectoApplication.class, args);
	}

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
		driverRepositoryJpa.save(driver);

		// DRIVER -> TRUCKS
		var truckDriver = new Truck();
		truckDriver.setCode("TRUCK007");
		truckDriver.setEnabled(true);
		truckDriver.setDriver(driver);
		truckRepositoryJpa.save(truckDriver);

		// TRUCK -> PACKAGES
		var truckRecent = truckRepositoryJpa.findByCode("TRUCK007").orElseThrow( ()-> new IllegalStateException(""));

		// PACKAGES
		var myPackage = new Package();
		myPackage.setCode("PKG007");
		myPackage.setWeight(15.0);
		myPackage.setSchedule(LocalDateTime.now());
		myPackage.setTruck(truckRecent);
		packageRepositoryJpa.save(myPackage);

		var packageRecent = packageRepositoryJpa.findByCode("PKG007").orElseThrow( ()-> new IllegalStateException(""));

		// PACKAGE-PRODUCTS
		var packageProduct = new PackageProduct();
		packageProduct.setCode("PKG-PRD007");
		packageProduct.setWeight(30.0);
		packageProduct.setSku("#1256");
		packageProduct.setQuantity(2);
		packageProduct.setMyPackage(packageRecent);
		packageProductRepositoryJpa.save(packageProduct);


		var daniService = driverService.findAll();
		var depurationPoint = "depurationPoint";

	}
}
