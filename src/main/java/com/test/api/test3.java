package com.test.api;

import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;


public class test3 {

    //在当前测试类开始时运行。
    @BeforeClass
    public static void beforeClass(){
        System.out.println("-------------------beforeClass");
    }

    //在当前测试类结束时运行。
    @AfterClass
    public static void afterClass(){
        System.out.println("-------------------afterClass");
    }

    //每个测试方法运行之前运行
    @BeforeMethod
    public void before(){
        System.out.println("=====beforeMethod");
    }

    //每个测试方法运行之后运行
    @AfterMethod
    public void after(){
        System.out.println("=====afterMethod");
    }

    @Test
    public void testCase1(){
        System.out.println("test case 1");
        assertEquals(5-3, 3);
    }

    @Test
    public void testCase2(){
        System.out.println("test case 2");
    }
}
