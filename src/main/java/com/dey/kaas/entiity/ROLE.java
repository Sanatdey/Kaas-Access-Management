package com.dey.kaas.entiity;

public enum ROLE {
    ROLE_SUPER_ADMIN(0),
    ROLE_ADMIN(1),
    ROLE_COMPNAY_ADMIN(2),
    ROLE_COMPANY_USER(3),
    ;

    int value;

    ROLE(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }

    public static ROLE fromValue(int i) {
        for (ROLE role : ROLE.values()) {
            if (role.value == i) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid ROLE value: " + i);
    }
}
