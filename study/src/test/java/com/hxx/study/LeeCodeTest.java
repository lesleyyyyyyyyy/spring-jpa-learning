package com.hxx.study;


import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author xin.hao
 * @create 2021/12/23 11:11
 */
public class LeeCodeTest {

    @Test
    public void leecodeTest() throws ParseException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(LeeCodeTest.class.getResource("").getPath());

        String path = LeeCodeTest.class.getResource("/").getPath();
        System.out.println(path);
//        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.get(Calendar.YEAR));
//        Date myDate1 = dateFormat1.parse("2009-06-01");
//        System.out.println(myDate1.getYear());
//        System.out.println(myDate1.toString());
//
//
//        calendar.setTime(new Date());
//        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 59);
//        calendar.set(Calendar.SECOND, 59);
//        System.out.println(calendar.getTime().toString());
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
//
//        Calendar c = Calendar.getInstance();
////        c.set(2021, Calendar.FEBRUARY, 3);
//        int currentMonth = c.get(Calendar.MONTH) + 1;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String firstDayOfCurrentQuarter = null;
//        try {
//            if (currentMonth >= 1 && currentMonth <= 3) {
//                c.set(Calendar.MONTH, 2);
//                c.set(Calendar.DATE, 31);
//            } else if (currentMonth >= 4 && currentMonth <= 6) {
//                c.set(Calendar.MONTH, 5);
//                c.set(Calendar.DATE, 30);
//            } else if (currentMonth >= 7 && currentMonth <= 9) {
//                c.set(Calendar.MONTH, 8);
//                c.set(Calendar.DATE, 30);
//            } else if (currentMonth >= 10 && currentMonth <= 12) {
//                c.set(Calendar.MONTH, 11);
//                c.set(Calendar.DATE, 31);
//            }
//            System.out.println(c.getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        sumZero(5);
    }

    /**
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] list = new int[n];
        for (int i = 0; i <= n / 2; i += 2) {
            list[i] = 1 + i;
            list[i + 1] = -1 - i;
        }
        return list;
    }

    /**
     * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
     * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
     * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
     * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
     * <p>
     * 示例 1：
     * 输入：candyType = [1,1,2,2,3,3]
     * 输出：3
     * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
     * <p>
     * 示例 2：
     * 输入：candyType = [1,1,2,3]
     * 输出：2
     * 解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
     *
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<candyType.length;i++){
//            set.add(candyType[i]);
//        }
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
