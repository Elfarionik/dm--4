package com.example;

public class Task1 {
    /** if returns: true - graph is oriented;
     *             false - graph can be either oriented or non-oriented
     */
    public static boolean isOriented(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != mat[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
