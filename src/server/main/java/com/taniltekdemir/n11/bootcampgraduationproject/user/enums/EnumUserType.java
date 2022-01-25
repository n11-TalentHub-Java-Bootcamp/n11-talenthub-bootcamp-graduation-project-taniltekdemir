package com.taniltekdemir.n11.bootcampgraduationproject.user.enums;

public enum EnumUserType {

    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN")
    ;

    private String type;

    EnumUserType(String type) {
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
