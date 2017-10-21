package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design Excel Sum Formula
 *
 * 2D Array
 * String.substring()
 * String.indexOf()
 */
public class Problem631 {
    private List<String>[][] formulas;
    private int[][] values;

    public Problem631(int H, char W) {
        values = new int[H + 1][W + 1];
        formulas = new ArrayList[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 'A'; j <= W; j++) {
                formulas[i][j] = new ArrayList<>();
            }
        }
    }

    public void set(int r, char c, int v) {
        formulas[r][c].clear(); // clear formula
        if (values[r][c] != v) { // recalculate all formulas if value changed
            values[r][c] = v;
            for (int i = 1; i < formulas.length; i++) {
                for (int j = 'A'; j < formulas[i].length; j++) {
                    if (formulas[i][j].size() > 0) {
                        values[i][j] = calculateFormula(formulas[i][j]);
                    }
                }
            }
        }
    }

    public int get(int r, char c) {
        return values[r][c];
    }

    public int sum(int r, char c, String[] addends) {
        formulas[r][c].clear();
        formulas[r][c].addAll(Arrays.asList(addends));
        values[r][c] = calculateFormula(formulas[r][c]);
        return values[r][c];
    }

    private int getRow(String cell) {
        return Integer.parseInt(cell.substring(1));
    }

    private char getCol(String cell) {
        return cell.substring(0, 1).charAt(0);
    }

    private int calculateFormula(List<String> addends) {
        int sum = 0;
        for (String addend : addends) {
            int colon = addend.indexOf(':');
            if (colon == -1) {
                sum += values[getRow(addend)][getCol(addend)];
            } else {
                String leftTop = addend.substring(0, colon);
                String rightDown = addend.substring(colon + 1);
                for (int i = getRow(leftTop); i <= getRow(rightDown); i++) {
                    for (int j = getCol(leftTop); j <= getCol(rightDown); j++) {
                        sum += values[i][j];
                    }
                }
            }
        }
        return sum;
    }
}
