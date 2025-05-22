package com.petruth.price_comparator_market.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitConverterTest {
    @Test
    void testNormalizeToStandardUnit() {
        assertEquals(1.0, UnitConverter.normalizeToStandardUnit(1000, "g"));
        assertEquals(2.5, UnitConverter.normalizeToStandardUnit(2500, "ml"));
        assertEquals(3.0, UnitConverter.normalizeToStandardUnit(3.0, "kg")); // deja în standard
    }

    @Test
    void testComputePricePerStandardUnit() {
        double pricePerKg = UnitConverter.computePricePerStandardUnit(10.0, 1000, "g");
        assertEquals(10.0, pricePerKg);
    }

    @Test
    void testGetStandardUnit() {
        assertEquals("kg", UnitConverter.getStandardUnit("g"));
        assertEquals("l", UnitConverter.getStandardUnit("ml"));
        assertEquals("rolă", UnitConverter.getStandardUnit("role"));
        assertEquals("buc", UnitConverter.getStandardUnit("buc"));
    }
}
