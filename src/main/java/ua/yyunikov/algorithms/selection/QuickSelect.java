package ua.yyunikov.algorithms.selection;

import ua.yyunikov.algorithms.util.ArrayUtils;

import java.util.Random;

/**
 * QuickSelect (Randomized selection) algorithm for finding n-th ranked (minimum) element in the array.
 * Based on the same idea as QuickSort algorithm.
 * Running time is O(n*log(n)).
 */
public class QuickSelect extends Selection {

    private final Random random = new Random(System.currentTimeMillis());

    @Override
    protected int doSelect(final int[] array, final int rankElementIndex) {
        return randomizedSelect(array, rankElementIndex, 0, array.length);
    }

    /**
     * Randomly chooses pivot index between start point and the end point.
     *
     * @param startPoint lowest bound to choose the pivot from
     * @param endPoint highest bound to choose the pivot from
     * @return pivot index between start point and end point
     */
    protected int choosePivotIndex(final int startPoint, final int endPoint)  {
        if (startPoint == endPoint) {
            return startPoint;
        }

        return random.nextInt(endPoint - startPoint) + startPoint;
    }

    private int randomizedSelect(final int[] array, final int rankElementIndex, final int leftIndex, final int rightIndex) {
        if (leftIndex < rightIndex) {
            final int pivotIndex = choosePivotIndex(leftIndex, rightIndex - 1);
            final int newPivotIndex = partition(array, pivotIndex, leftIndex, rightIndex);

            if (newPivotIndex > rankElementIndex) {
                randomizedSelect(array, rankElementIndex, leftIndex, newPivotIndex);
            } else if (newPivotIndex < rankElementIndex) {
                randomizedSelect(array, rankElementIndex, newPivotIndex + 1, rightIndex);
            } else {
                return array[newPivotIndex];
            }
        }

        return array[rankElementIndex];
    }

    private int partition(final int[] array, final int pivotIndex, final int leftIndex, final int rightIndex) {
        // put the pivot to the first position of part to be sorted
        ArrayUtils.swap(array, leftIndex, pivotIndex);
        final int pivot = array[leftIndex];

        int partitionedMiddle = leftIndex + 1; // holds the middle point between partitioned elements
        // left from partitionedMiddle are less than the pivot, right from partitionedMiddle are bigger than the pivot
        for (int currentPosition = leftIndex + 1; currentPosition < rightIndex; currentPosition++) {
            // swap only if element is less than the pivot
            // otherwise it stays on the right part (where the bigger elements than the pivot are)
            if (array[currentPosition] < pivot) {
                ArrayUtils.swap(array, currentPosition, partitionedMiddle);
                partitionedMiddle++;
            }
        }

        // place the pivot at the partitioned middle
        // so elements less than the pivot are left from it, and the ones bigger than the pivot are right from it
        ArrayUtils.swap(array, leftIndex, partitionedMiddle - 1);
        return partitionedMiddle - 1;
    }
}
