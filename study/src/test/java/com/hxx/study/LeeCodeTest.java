package com.hxx.study;


import org.junit.jupiter.api.Test;

/**
 * @Author xin.hao
 * @create 2021/12/23 11:11
 */
public class LeeCodeTest {

    @Test
    public void leecodeTest() {
        sumZero(5);
    }

    /**
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] list = new int[n];
        for (int i = 0; i <= n / 2; i+=2) {
            list[i] = 1 + i;
            list[i+1] = -1 - i;
        }
        return list;

    }
}
