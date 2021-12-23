package com.hxx.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void logTest() {
        //log.info("aaaaa[{}]", "b");

        String a = "1,5,6,8,2";
        String[] split = a.split(",");
        for (String s : split) {
            Integer integer = Integer.parseInt(s);
            System.out.println(integer + 1);

        }
        List<String> str = new ArrayList<>();
        str.add("abc");
        str.add("123");
        //System.out.println(String.join("-", str));
        System.out.println(String.format("%06d", str.get(1)));
    }

}
