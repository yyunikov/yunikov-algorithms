package ua.yyunikov.algorithms.sort;

import ua.yyunikov.algorithms.util.ArrayUtils;

import java.util.Random;

public class QuickSort extends Sort {

    @Override
    protected void doSort(final int[] array) {
        quickSort(array, 0, array.length);
    }

    /**
     * Chooses pivot index between start point and the end point.
     *
     * @param startPoint lowest bound to choose the pivot from
     * @param endPoint highest bound to choose the pivot from
     * @return pivot index between start point and end point
     */
    protected int choosePivotIndex(final int startPoint, final int endPoint) {
        if (startPoint == endPoint) {
            return startPoint;
        }

        final Random random = new Random(System.currentTimeMillis());
        return random.nextInt(endPoint - startPoint) + startPoint;
    }

    private void quickSort(final int[] array, final int leftIndex, final int rightIndex) {
        if (leftIndex < rightIndex) {
            final int pivotIndex = choosePivotIndex(leftIndex, rightIndex - 1);
            final int newPivotIndex = partition(array, pivotIndex, array.length);

            quickSort(array, leftIndex, newPivotIndex);
            quickSort(array, newPivotIndex + 1, rightIndex);
        }
    }

    private int partition(final int[] array, final int pivotIndex, final int rangeIndex) {
        // place the pivot at first position
        ArrayUtils.swap(array, 0, pivotIndex);
        final int pivot = array[0];

        int partitionedMiddle = 1; // holds the middle point between partitioned elements
        // left from partitionedMiddle are less than the pivot, right from partitionedMiddle are bigger than the pivot
        for (int currentPosition = 1; currentPosition < rangeIndex; currentPosition++) {
            // swap only if element is less than the pivot
            // otherwise it stays on the right part (where the bigger elements than the pivot are)
            if (array[currentPosition] < pivot) {
                ArrayUtils.swap(array, currentPosition, partitionedMiddle);
                partitionedMiddle++;
            }
        }

        // place the pivot at the partitioned middle
        // so elements less than the pivot are left from it, and the ones bigger than the pivot are right from it
        ArrayUtils.swap(array, 0, partitionedMiddle - 1);
        return partitionedMiddle - 1;
    }
}