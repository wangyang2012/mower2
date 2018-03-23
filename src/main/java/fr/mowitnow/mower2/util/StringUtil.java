package fr.mowitnow.mower2.util;

public interface StringUtil {

    static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }
}
