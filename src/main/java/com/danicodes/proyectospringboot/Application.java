package com.danicodes.proyectospringboot;

import com.danicodes.proyectospringboot.dao.drivers.DriverRepositoryJpa;
import com.danicodes.proyectospringboot.dao.package_products.PackageProductRepositoryJpa;
import com.danicodes.proyectospringboot.dao.packages.PackageRepositoryJpa;
import com.danicodes.proyectospringboot.dao.trucks.TruckRepositoryJpa;
import com.danicodes.proyectospringboot.domain.drivers.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


		var driver = new Driver();
		driver.setCode("007");
		driver.setName("SuperDani");
		driver.setCellphone("569 12312312");
		driver.setEmail("driver1@elDriver.com");
		driver.setEnabled(true);

		driverRepositoryJpa.save(driver);

	}
}
