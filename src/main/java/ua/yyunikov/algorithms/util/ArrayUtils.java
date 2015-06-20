package ua.yyunikov.algorithms.util;

import java.util.Arrays;

/**
 * Utilities for performing different kind of operations with arrays.
 */
public interface ArrayUtils {

    /**
     * Swaps two elements in the array.
     *
     * @param array array with element
     * @param pos1 index of first element
     * @param pos2 index of second element
     */
    static void swap(final int[] array, final int pos1, final int pos2) {
        final int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    /**
     * Splits array into two smaller arrays. If the array length is odd then the right part (0 index) will always be bigger.
     * Example: array 2, 1, 3, 5, 4 will be splitted into 2, 1 and 3, 5, 4,
     *
     * @param array array to split
     * @return two arrays as a split result, 0 index - left part (equal by length or bigger then right part), 1 index - right part.
     */
    static int[][] split(final int[] array) {
        final int[] part1 = Arrays.copyOfRange(array, 0, array.length / 2);
        final int[] part2 = Arrays.copyOfRange(array, array.length / 2, array.length);

        return twoDimensionalArray(part1, part2);
    }

    /**
     * Splits array into two smaller arrays at the given index. The index element will not be part of any splitted arrays.
     *
     * Example: array 2, 1, 3, 5, 4 will be splitted at index 2 (element with value 3) into 2, 1 and 5, 4,
     *
     * @param array array to split
     * @return two arrays as a split result.
     */
    static int[][] splitBeforeAndAfterIndex(final int[] array, final int index) {
        final int[] part1 = Arrays.copyOfRange(array, 0, index);
        final int[] part2 = Arrays.copyOfRange(array, index, array.length);

        return twoDimensionalArray(part1, part2);
    }

    /**
     * Creates one two-dimensional array from two one-dimensional arrays.
     *
     * @param array1 first part of two dimensional array (at index 0)
     * @param array2 second part of two dimensional array (at index 1)
     * @return two dimensional array from array1 and array2
     */
    static int[][] twoDimensionalArray(final int[] array1, final int[] array2) {
        final int[][] result = new int[2][];
        result[0] = array1;
        result[1] = array2;

        return result;
    }
}
