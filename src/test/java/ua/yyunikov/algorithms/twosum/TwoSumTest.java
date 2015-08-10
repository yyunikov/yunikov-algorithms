package ua.yyunikov.algorithms.twosum;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.AlgorithmTest;
import ua.yyunikov.algorithms.util.FileUtils;

import java.io.IOException;

public class TwoSumTest extends AlgorithmTest {

    private static final int[] TEST_ARRAY = new int[]{2, 4, 5, -11, 5, 0};

    @Test
    public void testBinaryTwoSum() {
        testTwoSum("Binary search two sum algorithm", new BinarySearchTwoSum());
    }

    @Test
    public void testHashTableTwoSum() {
        testTwoSum("Hash table two sum algorithm", new HashTableTwoSum());
    }

    private void testTwoSum(final String algorithmName, final TwoSumAlgorithm twoSumAlgorithm) {
        runningTimeOf(algorithmName, () -> {
            // test 1
            Assert.assertEquals(true, twoSumAlgorithm.twoSumExists(TEST_ARRAY, 9));
            Assert.assertEquals(true, twoSumAlgorithm.twoSumExists(TEST_ARRAY, -11));
            Assert.assertEquals(true, twoSumAlgorithm.twoSumExists(TEST_ARRAY, 10, false));
            Assert.assertEquals(false, twoSumAlgorithm.twoSumExists(TEST_ARRAY, 10, true));

            // test 2
            try {
                final long[] longArray = FileUtils.toLongArray("src/test/java/ua/yyunikov/algorithms/twosum/2sum.txt");
                int counter = 0;
                for (int i = -10000; i <= 10000; i++) {
                    if (twoSumAlgorithm.twoSumExists(longArray, i, true)) {
                        counter++;
                    }
                }

                System.out.println(counter);
            } catch (final IOException e) {
                System.err.println("Unexpected error: " + e);
            }
        });
    }
}
