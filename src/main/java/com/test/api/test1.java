package com.test.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.*;


import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class test1 {

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


    @Test(description = "case1")
    public void GetParam() {
        given()
                .queryParam("userId", 1).  //或者是使用 param("userId",1).

                when()
                .get("http://jsonplaceholder.typicode.com/posts").

                then()
                .statusCode(200)
                .body("title", hasItem("eum et est occaecati"));
    }

    @Test
    public void PostTextParam(){
        given()
                .formParam("title","test")
                .formParam("body","ABCDRESS")
                .formParam("userId", 3)
                .contentType("text/html; charset=UTF-8").

                when()
                .post("http://jsonplaceholder.typicode.com/posts").

                then()
                .statusCode(201);
    }

//    1.3 多个请求参数
//    当有过个请求参数的时候，可以像上边写的，写多个param()方法，或者存为一个字符串。
//    其实也可以将参数定义为一个集合，存放在集合中，再传给body方法。

    //不通过
//    @Test
//    public void testMoreParams(){
//        HashMap<String, String> test1 = new HashMap<String,String>();
//        test1.put("title", "test");
//        test1.put("body","Test123");
//        test1.put("userId","7");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(test1).
//
//                when()
//                .post("http://jsonplaceholder.typicode.com/posts").
//
//                then()
//                .statusCode(201);
//    }



    @Test
    //方法一：get
    public void getTest1(){
        given().
                when()
                .get("https://api.himalaya.com/himalaya-portal/homePage/listAlbumsByTag?countryId=1&tagId=0&pageId=1&pageSize=20").

                then()
                .statusCode(200)
                .body("success",equalTo(true));
    }

    @Test
    //方法二：get
    public void getTest2(){
        given().log().all()
                .param("countryId",1)
                .param("tagId",0)
                .param("pageSize",20)

                .when()
                .get("https://api.himalaya.com/himalaya-portal/homePage/listAlbumsByTag")

                .then().log().all()
                .statusCode(200)
                .body("success",equalTo(true));
    }

//4.请求Cookie,  直接将所有的cookies用header(key, value)方法传递。
    @Test
    public void getMembershipActive(){
        given().log().all()  //请求，打印
                .header("cookie","1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b")
                .contentType("application/json").

                when()  //执行
                .get("https://api.himalaya.com/hipoints-web/trade/user/membership/active").

                then().log().all()   //断言返回，打印
                .statusCode(200)
                .body("data.permissionProducts.albumId",hasItem(1163800));
    }


    @Test
    public void postRecommendAlbums(){
        given().log().all()
                .param("categoryIds",1)
                .param("countryId",1)
                .param("pageId",1)
                .param("pageSize",18)
                .header("cookie","1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b")
                .contentType("application/x-www-form-urlencoded").


                when()
                .post("https://api.himalaya.com/imobile/guide/recommendAlbums").

                then().log().all()
                .statusCode(200)
                .body("ret",equalTo(0))
                .body("list.albumId",notNullValue());   //包含什么字段可以用断言 notNullValue()不为空

    }


    @Test
        public void testCase1(){
            assertEquals(2+2, 4);
        }



}
