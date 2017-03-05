package com.yunikov.algorithms.graphs.cuts;

import com.yunikov.algorithms.graphs.GraphAlgorithmTest;
import org.junit.Assert;
import org.junit.Test;
import com.yunikov.algorithms.util.FileUtils;

import java.io.IOException;

public class MinCutsCountTest extends GraphAlgorithmTest {

    @Test
    public void testRandomContraction() {
        testMinimumCuts("Random Contraction", new RandomContractionMinCutsCount());
    }

    private void testMinimumCuts(final String algorithmName, final MinCutsCount minCutsCount) {
        runningTimeOf(algorithmName, () -> {
            // test 1
            int minResult = Integer.MAX_VALUE;
            for (int i = 0; i < 1000; i++) {
                final int result = minCutsCount.count(new int[][]{
                        {2, 3, 4},
                        {1, 3},
                        {1, 2, 4},
                        {1, 3}
                });
                if (result < minResult) {
                    minResult = result;
                }
            }

            Assert.assertEquals(2, minResult);

            // test 2
            int minResult2 = Integer.MAX_VALUE;
            for (int i = 0; i < 1000; i++) {
                final int result = minCutsCount.count(createTestGraph());
                if (result < minResult2) {
                    minResult2 = result;
                }
            }
            Assert.assertEquals(2, minResult2);

            // test 3
            try {
                final int[][] array = FileUtils.twoDimensionalArray("src/test/java/ua/yyunikov/algorithms/graphs/testGraph.txt");
                int minResult3 = Integer.MAX_VALUE;
                for (final int[] anArray : array) {
                    final int result = minCutsCount.count(array);
                    if (result < minResult3) {
                        minResult3 = result;
                    }
                }

                Assert.assertEquals(17, minResult3);
            } catch (final IOException e) {
                System.err.println("Unexpected error: " + e);
            }
        });
    }
}
