package com.petruth.price_comparator_market.util;

public class UnitConverter {
    public static double normalizeToStandardUnit(double quantity, String unit) {
        return switch (unit.toLowerCase()) {
            case "g", "ml" -> quantity / 1000.0;
            default -> quantity;
        };
    }

    public static String getStandardUnit(String unit) {
        return switch (unit.toLowerCase()) {
            case "g" -> "kg";
            case "ml" -> "l";
            case "role" -> "rolă";
            default -> unit.toLowerCase();
        };
    }

    public static double computePricePerStandardUnit(double price, double quantity, String unit) {
        double normalizedQuantity = normalizeToStandardUnit(quantity, unit);
        return normalizedQuantity > 0 ? price / normalizedQuantity : 0;
    }

    public static String formatPricePerStandardUnit(double price, double quantity, String unit, String currency) {
        String standardUnit = getStandardUnit(unit);
        double pricePerStandardUnit = computePricePerStandardUnit(price, quantity, unit);
        return String.format("%.2f %s/%s", pricePerStandardUnit, currency, standardUnit);
    }
}
