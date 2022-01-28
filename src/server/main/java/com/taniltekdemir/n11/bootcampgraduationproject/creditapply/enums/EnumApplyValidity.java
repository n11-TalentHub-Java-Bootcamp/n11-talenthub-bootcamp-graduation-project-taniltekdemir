package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums;

public enum EnumApplyValidity {

    ACTIVE("ACTIVE"),
    PASSIVE("PASSIVE")
    ;

    private String type;

    EnumApplyValidity(String type) {
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
