package org.example.prostorazvlecaus.model;

public enum ServiceType {
    CUTTING("Резка"),
    POLISHING("Полировка"),
    GRINDING("Шлифовка"),
    BURNING("Обжиг камня"),
    THERMAL_COLOR("Термообработка цвета"),
    LASER_ENGRAVING("Лазерная гравировка"),
    HAND_ENGRAVING("Ручная гравировка"),
    BAS_RELIEF("Создание барельефа");

    private final String displayName;

    ServiceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}