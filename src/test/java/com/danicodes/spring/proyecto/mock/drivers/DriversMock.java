package com.danicodes.spring.proyecto.mock.drivers;

import com.danicodes.spring.proyecto.domain.drivers.Driver;

public class DriversMock {
    public static Driver build() {
        var driver = new Driver();
        driver.setName("SuperDani");

        return driver;
    }
}
