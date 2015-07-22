package ua.yyunikov.algorithms.util;

import java.util.Random;

public interface RandomUtils {

    static int randomInt(final int from, final int to) {
        final Random random = new Random(System.currentTimeMillis());
        return random.nextInt(to - from) + from;
    }

    static int randomFromArray(final int[] array, final int from) {
        final int index = randomInt(from, array.length);
        return array[index];
    }
}
