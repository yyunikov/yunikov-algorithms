package com.yunikov.algorithms.twosum;

import com.yunikov.algorithms.AlgorithmTest;
import org.junit.Assert;
import org.junit.Test;
import com.yunikov.algorithms.util.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TwoSumTest extends AlgorithmTest {

    private static final int[] TEST_ARRAY = new int[]{2, 4, 5, -11, 5, 0};

    @Test
    public void testBinaryTwoSum() {
        testTwoSum("Binary search two sum algorithm", new BinarySearchTwoSum());
    }

    @Test
    public void testHashTableTwoSum() {
        testTwoSum("Hash table two sum algorithm", new HashTableTwoSum());
        // testTwoSumOnHugeData(new HashTableTwoSum());
    }

    private void testTwoSum(final String algorithmName, final TwoSumAlgorithm twoSumAlgorithm) {
        runningTimeOf(algorithmName, () -> {
            Assert.assertEquals(true, twoSumAlgorithm.twoSumExists(TEST_ARRAY, 9));
            Assert.assertEquals(true, twoSumAlgorithm.twoSumExists(TEST_ARRAY, -11));
            Assert.assertEquals(true, twoSumAlgorithm.twoSumExists(TEST_ARRAY, 10, false));
            Assert.assertEquals(false, twoSumAlgorithm.twoSumExists(TEST_ARRAY, 10, true));
        });
    }

    private void testTwoSumOnHugeData(final HashTableTwoSum hashTableTwoSum) {
        try {
            final long[] longArray = FileUtils.toLongArray("src/test/java/ua/yyunikov/algorithms/twosum/2sum.txt");
            final Map<Long, Long> hashMap = new HashMap<>(longArray.length);
            for (long element: longArray) {
                hashMap.put(element, element);
            }

            int counter = 0;
            for (int i = -10000; i <= 10000; i++) {
                if (hashTableTwoSum.twoSumExists(hashMap, i, true)) {
                    counter++;
                }
            }

            System.out.println(counter);
        } catch (final IOException e) {
            System.err.println("Unexpected error: " + e);
        }
    }
}
