package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {
    
    private String[] carToStringArray(Car car) {
        return new String[] { car.getMake(), car.getModel(), Integer.toString(car.getYear()) };
    }

    @Test 
    void testCarEqualityWithMakeModelYear() {
        String[] expected = { "Toyota", "Supra", "1998"};
        Car actual = new Car("Toyota", "Supra", 20000, 1998, 100000);
        assertArrayEquals(expected, carToStringArray(actual));
    }
    
}
