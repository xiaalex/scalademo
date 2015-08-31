package com.demo;

import java.lang.Math;

/**
 * If we have word ABD XNML, the following explains the algorithm
 *    X N M L
 * A  0 1 2 3 4
 * B  1 1 2 3 4
 * D  2 2 2 3 4
 *    3 3 3 3 4
 */
public class EditDistance {
    public int distance(String w1, String w2) {
        int w1len = w1.length();
        int w2len = w2.length();

        int[][] minCosts = new int[w1len+1][w2len+1];
        // start zero
        minCosts[0][0] = 0;

        for (int i = 0; i < w1len; i++) {
            for (int j = 0; j < w2len; j++) {
                // 0 0
                int temp = minCosts[i][j] + ((w1.charAt(i) == w2.charAt(j)) ? 0 : 1);
                int curr = (minCosts[i + 1][j + 1] == 0) ? Integer.MAX_VALUE : minCosts[i + 1][j + 1];
                minCosts[i + 1][j + 1] = Math.min(temp, curr);

                // 0 1
                temp = 1 + minCosts[i][j + 1];
                curr = (minCosts[i][j + 1] == 0) ? Integer.MAX_VALUE : minCosts[i][j + 1];
                minCosts[i][j + 1] = Math.min(temp, curr);

                // 1 0
                temp = 1 + minCosts[i + 1][j];
                curr = (minCosts[i + 1][j] == 0) ? Integer.MAX_VALUE : minCosts[i + 1][j];
                minCosts[i + 1][j] = Math.min(temp, curr);
            }
        }
        return minCosts[w1len][w2len];
    }
}

