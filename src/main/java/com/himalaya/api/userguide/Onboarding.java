package com.himalaya.api.userguide;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Onboarding {

    @Test(description = "新手引导_推荐专辑")
    public void postRecommendAlbums() {
        Response response =
                given().log().all()
                        .param("categoryIds", 1)
                        .param("countryId", 1)
                        .param("pageId", 1)
                        .param("pageSize", 18)
                        .header("cookie", "1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b")
                        .contentType("application/x-www-form-urlencoded").


                                when()
                        .post("https://api.himalaya.com/imobile/guide/recommendAlbums").

                                then().log().all()
                        .statusCode(200)
                        .body("ret", equalTo(0))
                        //包含什么字段可以用断言 notNullValue()不为空
                        .body("list.albumId", notNullValue()).
                                extract().response();



        System.out.println("statusCode = "+ response.statusCode());


    }

}
