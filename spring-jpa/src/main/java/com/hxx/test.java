package com.hxx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xin.hao
 * @create 2021/3/24 16:39
 */
public class test {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        System.out.println(formatter.format(date));
    }
}
