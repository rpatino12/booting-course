package com.rpatino12.lil.booting_course.data.entity;

public enum Position {
    HOUSEKEEPING, FRONT_DESK, SECURITY, CONCIERGE;

    public String toString() {
        switch (this) {
            case CONCIERGE:
                return "Concierge";
            case SECURITY:
                return "Security";
            case FRONT_DESK:
                return "Front desk";
            case HOUSEKEEPING:
                return "Housekeeping";
            default:
                return "";
        }
    }
}
