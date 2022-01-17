package com.hxx.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void logTest() throws ParseException {
        //log.info("aaaaa[{}]", "b");

//        String a = "1,5,6,8,2";
//        String[] split = a.split(",");
//        for (String s : split) {
//            Integer integer = Integer.parseInt(s);
//            System.out.println(integer + 1);
//
//        }
//        List<String> str = new ArrayList<>();
//        str.add("abc");
//        str.add("123");
//        //System.out.println(String.join("-", str));
//        System.out.println(String.format("%06d", str.get(1)));

//        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date star = dft.parse("2021-12-03");//开始时间
//            Date endDay=dft.parse("2021-12-13");//结束时间
//            Long starTime=star.getTime();
//            Long endTime=endDay.getTime();
//            Long num=endTime-starTime;//时间戳相差的毫秒数
//            System.out.println("相差天数为："+num/24/60/60/1000);//除以一天的毫秒数
//            while (!star.after(endDay)){
//                System.out.println(star.toString());
//                Calendar c = Calendar.getInstance();
//                c.setTime(star);
//                c.add(Calendar.DATE, 1);
//                Date
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        System.out.println(calendar.getTime().toString());

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021,Calendar.DECEMBER,16);
        System.out.println(calendar2.toString());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(sdf.format(new Date("2021-12-16")));
//        Date date = new Date();
//        calendar2.setTime(date);
        int weeksInWeekYear = calendar1.getWeeksInWeekYear();
        int weeksInWeekYear1 = calendar2.getWeeksInWeekYear();
        int i = weeksInWeekYear - weeksInWeekYear1;
        int weekYear = calendar1.getWeekYear();

//        calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        calendar1.set(Calendar.HOUR_OF_DAY, 0);
//        calendar1.set(Calendar.MINUTE, 0);
//        calendar1.set(Calendar.SECOND, 0);
        System.out.println("calendar1-calendar2=" + i);

    }

}
