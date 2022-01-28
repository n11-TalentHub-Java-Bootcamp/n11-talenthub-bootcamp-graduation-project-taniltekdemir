package com.taniltekdemir.n11.bootcampgraduationproject.creditapply.enums;

public enum EnumApplyStatus {

    WAITING("WAITING"),
    EVALUATED("EVALUATED")
    ;

    private String type;

    EnumApplyStatus(String type) {
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
