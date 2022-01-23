package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums;

public enum EnumApplicationState {

    ACTIVE("ACTIVE"),
    PASSIVE("PASSIVE")
    ;

    private String type;

    EnumApplicationState(String type) {
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
