package ua.yyunikov.algorithms.sort;

public abstract class Sort {

    public int[] sort(final int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }

        return doSort(array);
    }

    protected abstract int[] doSort(final int[] array);
}
