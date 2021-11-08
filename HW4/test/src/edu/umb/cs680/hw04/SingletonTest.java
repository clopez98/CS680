package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    
    @Test
    public void checkNotNull() {
        Singleton singleton = Singleton.getInstance();

        assertNotNull(singleton);
    }

    @Test
    public void checkSameInstance() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        assertSame(singleton1.hashCode(), singleton2.hashCode());
    }
    
}
