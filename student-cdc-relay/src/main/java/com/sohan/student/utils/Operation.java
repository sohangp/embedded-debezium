package com.sohan.student.utils;

/**
 * Enum to derive the operation that was performed in the DataBase.
 */
public enum Operation {

    READ("r"),
    CREATE("c"),
    UPDATE("u"),
    DELETE("d");

    private final String code;

    private Operation(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }

    public static Operation forCode(String code) {
        Operation[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Operation op = var1[var3];
            if (op.code().equalsIgnoreCase(code)) {
                return op;
            }
        }
        return null;
    }
}