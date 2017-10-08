package com.leetcode;

/**
 * Unique Binary Search Trees
 *
 * Dynamic Programming.
 *
 * G(n): the number of unique BST for a sequence of length n.
 * G(0) = G(1) = 0
 * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
 * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
 * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n  (the trick here is: the number of unique BSTs only depends on number of
 * continuous integers, not the actual values)
 * Combining the above two formulas:
 * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)  (G(n) depends on G(n-1), G(n-2), ..., G(0))
 *
 */
public class Problem96 {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i = 2; i <= n; ++i) {
            for(int j = 0; j <= i - 1; ++j) {
                G[i] += G[j] * G[i - 1 - j];
            }
        }
        return G[n];
    }
}
