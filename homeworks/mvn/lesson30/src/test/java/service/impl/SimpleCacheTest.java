package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SimpleCache unit tests
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 20.07.2021
 */
class SimpleCacheTest {
    private static final String[][] DATA = {{"cache-1", "cache-1-Key-1", "cache-1-Key-1-Value"},
                                             {"cache-1", "cache-1-Key-2", "cache-1-Key-2-Value"},
                                             {"cache-2", "cache-2-Key-1", "cache-2-Key-1-Value"},
                                             {"cache-3", "cache-3-Key-1", "cache-3-Key-1-Value"}};
    private static SimpleCache tested;

    @BeforeEach
    void setUp() {
        tested = new SimpleCache();
    }

    @Test
    void put() {
        assertTrue(tested.put(DATA[0][0], DATA[0][1], DATA[0][2])); // correct cache, key and data
        assertFalse(tested.put(null, DATA[1][1], DATA[1][2])); // null cache, correct key and data
        assertFalse(tested.put(DATA[2][0], null, DATA[2][2])); // correct cache, null key, correct data
        assertFalse(tested.put(DATA[3][0], DATA[3][1], null)); // correct cache and key, incorrect data
    }

    @Test
    void get() {
        tested.put(DATA[0][0], DATA[0][1], DATA[0][2]);
        tested.put(DATA[1][0], DATA[1][1], DATA[1][2]);
        tested.put(DATA[2][0], DATA[2][1], DATA[2][2]);

        assertEquals(tested.get(DATA[0][0], DATA[0][1]), DATA[0][2]); // correct cache, key and data
        assertNotEquals(tested.get(DATA[0][0], DATA[0][1]), DATA[1][2]); //  correct cache and key, incorrect data
        assertNotNull(tested.get(DATA[0][0], DATA[0][1])); // correct cache and key, not null data
        assertNull(tested.get(null, DATA[1][1])); // null cache, correct key
        assertNull(tested.get(DATA[1][0], null)); // correct cache, null key
        assertNull(tested.get(DATA[2][0], DATA[3][1])); // correct cache, incorrect key
        assertNull(tested.get(DATA[3][0], DATA[2][1])); // incorrect cache, correct key
    }

    @Test
    void clear() {
        tested.put(DATA[0][0], DATA[0][1], DATA[0][2]);
        tested.put(DATA[1][0], DATA[1][1], DATA[1][2]);
        tested.put(DATA[2][0], DATA[2][1], DATA[2][2]);

        assertEquals(tested.get(DATA[0][0], DATA[0][1]), DATA[0][2]); // correct cache, key and data
        assertNotNull(tested.get(DATA[0][0], DATA[0][1])); // correct cache and key, not null data
        tested.clear(DATA[0][0]);
        assertNull(tested.get(DATA[0][0], DATA[0][1])); // null data after clear()
        assertNotEquals(tested.get(DATA[0][0], DATA[0][1]), DATA[0][2]); // no data after clear()
        assertEquals(tested.get(DATA[2][0], DATA[2][1]), DATA[2][2]); // correct cache, key and data
        tested.clear();
        assertNull(tested.get(DATA[0][0], DATA[0][1])); // null data after clear()
        assertNull(tested.get(DATA[1][0], DATA[1][1])); // null data after clear()
        assertNull(tested.get(DATA[2][0], DATA[2][1])); // null data after clear()
    }
}