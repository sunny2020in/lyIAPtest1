package com.himalaya.api.subscribe;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Subscribe {

    @Test(description = "查询订阅")
    public void querySubscribe(){
        given().log().all()
                .header("cookie","1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b")
                .contentType("application/json").

                when()  //执行
                .get("http://api.himalaya.com/isubscribe/v1/subscribe/list?pageId=1&pageSize=15").

                then().log().all()   //断言返回，打印
                .statusCode(200)
                .body("ret",equalTo(0))
                .body("data.subscribeAlbumResult.list.albumId",notNullValue());


    }


}
