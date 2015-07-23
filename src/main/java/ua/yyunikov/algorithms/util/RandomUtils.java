package ua.yyunikov.algorithms.util;

import java.util.Random;

/**
 * Utilities for performing different kind of operations with random values.
 */
public interface RandomUtils {

    /**
     * Generates a random int in specified range.
     *
     * @param from start of range
     * @param to end of range
     * @return random value between from and to
     */
    static int randomInt(final int from, final int to) {
        final Random random = new Random(System.currentTimeMillis());
        return random.nextInt(to - from) + from;
    }
}
