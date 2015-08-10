package ua.yyunikov.algorithms.search;

import java.util.Optional;

/**
 * Abstract class for different implementations of the
 * <a href="https://en.wikipedia.org/wiki/Search_algorithm">search algorithm</a> in arrays.
 */
public abstract class ArraySearch {

    /**
     * Performs a key search in sorted array.
     * @param array sorted array for search
     * @param key key to look for
     * @return index of found element in the array, empty otherwise.
     */
    public abstract Optional<Integer> searchSorted(final int[] array, final int key);

    /**
     * Performs a key search in unsorted array.
     * @param array unsorted array for search
     * @param key key to look for
     * @return index of found element in the array, empty otherwise.
     */
    public abstract Optional<Integer> search(final int[] array, final int key);

    /**
     * See {@link #searchSorted(int[], int)}.
     */
    public abstract Optional<Long> searchSorted(final long[] array, final long key);

    /**
     * See {@link #search(int[], int)}.
     */
    public abstract Optional<Long> search(final long[] array, final long key);
}
