package com.yunikov.algorithms.sort;

import java.util.PriorityQueue;

/**
 * <a href="https://en.wikipedia.org/wiki/Heapsort">Heap sort</a> algorithm. Running time is O(n*log(n)).
 */
public class HeapSort extends Sort {

    @Override
    protected void doSort(final int[] array) {
        final PriorityQueue<Integer> heap = new PriorityQueue<>(Integer::compareTo);
        for (final int element: array) {
            heap.add(element);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = heap.poll();
        }
    }
}
