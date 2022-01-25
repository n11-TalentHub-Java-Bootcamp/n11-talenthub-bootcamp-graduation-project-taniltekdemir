package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums;

public enum EnumApplicationValidity {

    ACTIVE("ACTIVE"),
    PASSIVE("PASSIVE")
    ;

    private String type;

    EnumApplicationValidity(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
