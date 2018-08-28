package person.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by SunChang on 2018/8/28
 */
public class IdUtils {
    public static final int ID_DEFAULT_LENGTH = 32;
    public static final char[] DEFAULT_SEED = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static char[] seed;

    public IdUtils() {
    }

    public static void setSeed(char[] _seed) {
        seed = _seed;
    }

    public static String randomString() {
        return randomString(32);
    }

    public static String randomString(int length) {
        return RandomStringUtils.random(length, seed);
    }

    static {
        seed = DEFAULT_SEED;
    }
}
