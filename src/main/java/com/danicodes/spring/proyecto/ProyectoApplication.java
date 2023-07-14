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

		// PACKAGES
		var myPackage = new Package();
		myPackage.setCode("PKG007");
		myPackage.setWeight(15.0);
		myPackage.setSchedule(LocalDateTime.now());
		packageRepositoryJpa.save(myPackage);

		// PACKAGE-PRODUCTS
		var packageProduct = new PackageProduct();
		packageProduct.setCode("PKG-PRD007");
		packageProduct.setWeight(30.0);
		packageProduct.setSku("#1256");
		packageProduct.setQuantity(2);
		packageProductRepositoryJpa.save(packageProduct);

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

		var truckDriver = new Truck();
		truckDriver.setCode("TRUCK007");
		truckDriver.setEnabled(true);
		truckDriver.setDriver(driver);
		truckRepositoryJpa.save(truckDriver);


		//
		// DRIVERS 2
		//

		var driver2 = new Driver();
		driver2.setCode("008");
		driver2.setName("SuperDani2");
		driver2.setCellphone("569 2");
		driver2.setEmail("driver2@elDriver.com");
		driver2.setEnabled(true);
		driverRepositoryJpa.save(driver2);

		//
		// DELETE DRIVER 2
		//

		//driverRepositoryJpa.delete(driver2);

		//var dani = driverRepositoryJpa.findAllByName("SuperDani");

		// TRUCKS
		var truck = new Truck();
		truck.setCode("TRUCK007");
		truck.setEnabled(true);
		truckRepositoryJpa.save(truck);

		var daniService = driverService.findAll();
		var depurationPoint = "depurationPoint";

	}
}
