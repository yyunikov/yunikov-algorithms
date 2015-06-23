package ua.yyunikov.algorithms.selection;

import java.util.NoSuchElementException;

/**
 * Abstract class for different kind of selection algorithms, which means
 * finding the "rank k element" of array (i.e., the one in position k if array was sorted)
 */
public abstract class Selection {

    /**
     * Selects i-th ranked element with specific algorithm.
     *
     * @param array array to sort
     * @throws NoSuchElementException if rankElementIndex is wrong index for passed array
     */
    public int select(final int[] array, final int rankElementIndex) {
        if (array.length == 0 || array.length == 1 && rankElementIndex != 0) {
            throw new NoSuchElementException(rankElementIndex + "-th element is out of bounds of array");
        }

        return doSelect(array, rankElementIndex);
    }

    protected abstract int doSelect(final int[] array, final int rankElementIndex);
}
