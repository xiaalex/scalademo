package com.demo;

import java.lang.Math;

public class MaxGap {
    // use max gap approach
    // For [3,4,-1,1], return 2
    public int firstMissingPositive(int A[], int n) {
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(A[i], max);

        int[] bucket = new int[max+1];
        for (int i = 0; i < n; i++)
            if (A[i] > 0)
                bucket[A[i]-1] = A[i];

        for (int i = 0; i < max; i++)
            if (bucket[i+1] - bucket[i] != 1)
                return bucket[i] + 1;
        return bucket[max-1] + 1;
    }
}
