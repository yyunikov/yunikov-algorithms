package ua.yyunikov.algorithms.util;

import java.util.Arrays;

public interface ArrayUtils {

    static void swap(final int[] array, final int pos1, final int pos2) {
        final int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    static int[][] split(final int[] array) {
        final int[] part1 = Arrays.copyOfRange(array, 0, array.length / 2);
        final int[] part2 = Arrays.copyOfRange(array, array.length / 2, array.length);

        final int[][] result = new int[2][];
        result[0] = part1;
        result[1] = part2;

        return result;
    }
}
