package com.optimagrowth.licenseserivce.util;

import java.util.NoSuchElementException;

public final class ApiValidationUtil {

    public static void requiredTrue(boolean value, String message) {
        if (!value) {
            throw new NoSuchElementException(message);
        }
    }
//
//    public static void requireFalse(boolean value, String message) {
//        if (value) {
//            throw new RequestValidationException(message);
//        }
//    }
//
//    public static void requireNotNull(Object value, String message) {
//        if (value == null) {
//            throw new RequestValidationException(message);
//        }
//    }
//
//    public static void requireNull(Object value, String message) {
//        if (value != null) {
//            throw new RequestValidationException(message);
//        }
//    }
}
