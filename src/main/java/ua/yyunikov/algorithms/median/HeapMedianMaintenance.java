package ua.yyunikov.algorithms.median;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implementation of median maintenance algorithm using 2 heaps: one with min number in the head, one with the max number in the tail.
 * Heaps perform rebalancing during insertion.
 */
public class HeapMedianMaintenance extends MedianMaintenance {

    @Override
    protected List<Integer> doFindOneByOne(final List<Integer> elements) {
        final List<Integer> resultList = new ArrayList<>(elements.size());
        final PriorityQueue<Integer> lowHeap = new PriorityQueue<>(this::maxComparatorExpression);
        final PriorityQueue<Integer> highHeap = new PriorityQueue<>(this::minComparatorExpression);

        for (final int element: elements) {
            insertNew(lowHeap, highHeap, element);
            rebalance(lowHeap, highHeap);

            final int medianIndex = medianIndex(lowHeap.size() + highHeap.size());
            if (medianIndex <= lowHeap.size()) {
                resultList.add(lowHeap.peek());
            } else {
                resultList.add(highHeap.peek());
            }
        }

        return resultList;
    }

    private void rebalance(final PriorityQueue<Integer> lowHeap, final PriorityQueue<Integer> highHeap) {
        if (lowHeap.size() - highHeap.size() > 1) {
            highHeap.add(lowHeap.poll());
        }
        if (highHeap.size() - lowHeap.size() > 1) {
            lowHeap.add(highHeap.poll());
        }
    }

    private void insertNew(final PriorityQueue<Integer> lowHeap, final PriorityQueue<Integer> highHeap, final int element) {
        if (highHeap.isEmpty() || element <= highHeap.peek()) {
            lowHeap.add(element);
        } else {
            highHeap.add(element);
        }
    }

    private int medianIndex(final int elementsSize) {
        if (elementsSize % 2 == 0) { // if even
            return elementsSize / 2;
        } else { // if odd
            return (elementsSize + 1) / 2;
        }
    }

    private int minComparatorExpression(final int x, final int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    private int maxComparatorExpression(final int x, final int y) {
        return (x > y) ? -1 : ((x == y) ? 0 : 1);
    }
}
