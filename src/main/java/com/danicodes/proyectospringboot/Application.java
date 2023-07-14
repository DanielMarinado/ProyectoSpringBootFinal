package com.danicodes.proyectospringboot;

import com.danicodes.proyectospringboot.dao.drivers.DriverRepositoryJpa;
import com.danicodes.proyectospringboot.dao.package_products.PackageProductRepositoryJpa;
import com.danicodes.proyectospringboot.dao.packages.PackageRepositoryJpa;
import com.danicodes.proyectospringboot.dao.trucks.TruckRepositoryJpa;
import com.danicodes.proyectospringboot.domain.drivers.Driver;
import com.danicodes.proyectospringboot.domain.package_products.PackageProduct;
import com.danicodes.proyectospringboot.domain.packages.Package;
import com.danicodes.proyectospringboot.domain.trucks.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private DriverRepositoryJpa driverRepositoryJpa;

	@Autowired
	private PackageRepositoryJpa packageRepositoryJpa;

	@Autowired
	private PackageProductRepositoryJpa packageProductRepositoryJpa;

	@Autowired
	private TruckRepositoryJpa truckRepositoryJpa;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*

			Pruebas para validar el modelo

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


		// DRIVERS
		var driver = new Driver();
		driver.setCode("007");
		driver.setName("SuperDani");
		driver.setCellphone("569 12312312");
		driver.setEmail("driver1@elDriver.com");
		driver.setEnabled(true);
		driverRepositoryJpa.save(driver);

		// TRUCKS
		var truck = new Truck();
		truck.setCode("TRUCK007");
		truck.setEnabled(true);
		truckRepositoryJpa.save(truck);

	}
}
