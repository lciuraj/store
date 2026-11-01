package pl.wsei.store.controller;

final class QuantityParam {

    private QuantityParam() {
    }

    static Integer parse(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            int quantity = Integer.parseInt(value.trim());
            return quantity > 0 ? quantity : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
