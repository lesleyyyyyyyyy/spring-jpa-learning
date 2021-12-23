package test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author xin.hao
 * @create 2021/4/15 10:45
 */

public class a {


    abstract class A{
        public abstract void aaa();
    }

    class B extends A {

        @Override
        public void aaa() {

        }
    }

    @Test
    public void a() {

        long a = 9L;
        long b = 6L;
        int round = Math.round(a / b);
        long percent = BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), BigDecimal.ROUND_HALF_UP).longValue();
        System.out.println(percent);

//        System.out.println("hello");
//        int str = 123;
//        System.out.println(String.format("%06d",str));
//
//        long a = 1000L;
//        long b = 36L;
//        System.out.println(a / b);

        BigDecimal bigDecimal = new BigDecimal("111.0000");
        System.out.println(bigDecimal.stripTrailingZeros());

        String tagCode = "123";
        String[] unionTagCodeList = new String[]{tagCode};

        System.out.println(Arrays.toString(unionTagCodeList));

        String str3 = "111,222，333,444";
        System.out.println("多个分隔符返回值 :");
        for (String retval : str3.split("[,，]")) {
            System.out.println(retval);
        }


    }
}
