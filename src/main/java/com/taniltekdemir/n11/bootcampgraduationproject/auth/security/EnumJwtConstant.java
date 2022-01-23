package com.taniltekdemir.n11.bootcampgraduationproject.auth.security;

public enum EnumJwtConstant {

    BEARER("Bearer ");

    private String constant;

    EnumJwtConstant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant;
    }
}
