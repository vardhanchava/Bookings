package com.example.bookings.models.enums;

public enum Status {
    CANCELLED("Cancelled"),
    CONFIRMED("CONFIRMED");


    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
