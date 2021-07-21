package service;

import org.junit.jupiter.api.Test;
import service.dto.Pair;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testToString() {
        String expected = "{\"one\",\"ONE\"}";
        Pair p = new Pair("one", "ONE");

        System.out.println("\t\tpair.toString() result: " + p);
        assertEquals(expected, p.toString());
    }
}