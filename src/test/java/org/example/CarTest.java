package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void testDefaultConstructor() {
        Car car = new Car();
        assertEquals("Unknown", car.getMake());
        assertEquals("Unknown", car.getModel());
        assertEquals(2000, car.getYear());
        assertEquals(0.0, car.getPrice(), 0.0);
    }

    @Test
    public void testParameterizedConstructor() {
        Car car = new Car("Toyota", "Camry", 2022, 25000.0);
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2022, car.getYear());
        assertEquals(25000.0, car.getPrice(), 0.0);
    }

    @Test
    public void testSettersAndGetters() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear(2023);
        car.setPrice(22000.0);

        assertEquals("Honda", car.getMake());
        assertEquals("Civic", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals(22000.0, car.getPrice(), 0.0);
    }

    @Test
    public void testSetYearBoundary() {
        Car car = new Car();
        car.setYear(1800);
        assertEquals(1886, car.getYear());

        car.setYear(2024);
        assertEquals(2024, car.getYear());
    }

    @Test
    public void testSetPriceBoundary() {
        Car car = new Car();
        car.setPrice(-1000.0);
        assertEquals(0.0, car.getPrice(), 0.0);

        car.setPrice(30000.0);
        assertEquals(30000.0, car.getPrice(), 0.0);
    }

    @Test
    public void testCalculateDepreciation() {
        Car car = new Car("Ford", "Mustang", 2020, 30000.0);
        double depreciatedPrice = car.calculateDepreciation();
        double expectedDepreciatedPrice = 30000.0 * Math.pow(0.85, 5);
        assertEquals(expectedDepreciatedPrice, depreciatedPrice, 0.01);
    }

    @Test
    public void testCalculateDepreciationZeroYears() {
        Car car = new Car("Ford", "Mustang", 2025, 30000.0);
        assertEquals(car.getPrice(), car.calculateDepreciation(), 0.001);
    }

    @Test
    public void testPrintMethod() {
        Car car = new Car("Tesla", "Model S", 2024, 90000.0);
        car.print();
    }
}

