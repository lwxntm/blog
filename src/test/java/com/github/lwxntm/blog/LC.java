package com.github.lwxntm.blog;

import java.util.Arrays;

public class LC {
    public static void main(String[] args) {
        int[] res = new LC().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
        System.out.println(Arrays.equals(res, new int[]{0, 0, 1, 1, 0, 0, 0, 0}));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }
        N = N % 14;
        if (N == 0) {
            N = 14;
        }

        int[] answer = new int[8];
        while (N > 0) {
            answer[0] = 0;
            for (int j = 1; j < 7; j++) {
                answer[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            answer[7] = 0;
            System.arraycopy(answer, 0, cells, 0, 8);
            N--;
        }
        return answer;
    }
}
