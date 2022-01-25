package com.taniltekdemir.n11.bootcampgraduationproject.creditapplication.enums;

public enum EnumApplicationStatus {

    WAITING("WAITING"),
    EVALUATED("EVALUATED")
    ;

    private String type;

    EnumApplicationStatus(String type) {
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
