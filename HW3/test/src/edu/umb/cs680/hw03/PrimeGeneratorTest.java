package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void zeroToTenRange() {
        PrimeGenerator generator = new PrimeGenerator(1, 10);
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        generator.generatePrimes();
        assertEquals(4, generator.primes.size());
        assertArrayEquals(expectedPrimes, generator.primes.toArray());
    }

    @Test
    public void negativeRange() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new PrimeGenerator(-10, 10);
        });
        assertEquals(exception.getMessage(), "Wrong input values: from=-10 to=10");
    }

    @Test
    public void fromGreaterThanTo() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            new PrimeGenerator(100, 10);
        });
        assertEquals(exception.getMessage(), "Wrong input values: from=100 to=10");
    }
}
