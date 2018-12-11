package com.example.llyc.myapp;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        assertEquals(4, 2 + 2);
        String str = "2018年12月4日";
        System.out.println(str.length());
        System.out.println(str.substring(8, 9));
        System.out.println(str.substring(8, 10));
    }
}