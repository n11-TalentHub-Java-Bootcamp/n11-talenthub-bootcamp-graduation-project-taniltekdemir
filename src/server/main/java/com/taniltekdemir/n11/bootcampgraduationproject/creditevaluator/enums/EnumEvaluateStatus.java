package com.taniltekdemir.n11.bootcampgraduationproject.creditevaluator.enums;

public enum EnumEvaluateStatus {

    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED")
    ;

    private String type;

    EnumEvaluateStatus(String type) {
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
