/*
 *     SPDX-License-Identifier: MIT
 *
 *     Copyright (C) EldoriaRPG Team and Contributor
 */
package de.eldoria.jacksonbukkit.util;

/**
 * Class giving easy access to reflection.
 */
public final class Reflections {
    private Reflections() {
        throw new UnsupportedOperationException("This is a utility class.");
    }

    /**
     * Checks whether the method with the signature exists
     *
     * @param clazz          class to check on
     * @param name           method name
     * @param parameterTypes method parameter
     * @return true when exists
     */
    public static boolean methodExists(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            return false;
        }
        return true;
    }
}
