package com.himalaya.api.hipointsweb;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Membership {
    //4.请求Cookie,  直接将所有的cookies用header(key, value)方法传递。
    @Test(description = "查询用户激活membership（返回大会员权益天数）")
    public void getMembershipActiveDay(){
        given().log().all()  //请求，打印
                .header("cookie","1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b")
                .contentType("application/json").

                when()  //执行
                .get("https://api.himalaya.com/hipoints-web/trade/user/membership/active").

                then().log().all()   //断言返回，打印
                .statusCode(200)
                .body("ret",equalTo(0))
                .body("data.permissionProducts.albumId",hasItem(1163800));
    }

    @Test(description = "membership有效会员")
    public void getMembershipActive(){
        given().log().all()  //请求，打印
                .header("cookie","user_type=0; 1&_device=iPhone&A54EF499-4F79-467A-B540-F89104B82D23&2.4.60; net-mode=WIFI; channel=ios-appstore; country_id=2; x-mulehorse-bucketIds=,; domain=api.himalaya.com; impl=com.ximalaya.xmlyi; locale=en_US; path=/; idfa=A54EF499-4F79-467A-B540-F89104B82D23; x-abtest-bucketIds=316418; JSESSIONID=DADF38BA83E0E26314D5DAD39EBDF817; 1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b; c-oper=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8")
                .contentType("application/json").

                when()  //执行
                .get("https://api.himalaya.com/hipoints-web/trade/user/membership/active?countryId=2&device=iPhone&scale=3&version=2.4.60").

                then().log().all()
                .statusCode(200)
                .body("ret",equalTo(0))
                .body("data.permissionProducts.albumId",hasItem(1163800))
                ;
    }

    @Test(description = "membership失效会员")
    public void getMembershipUnactive(){
        given().log().all()  //请求，打印
                .header("cookie","user_type=0; 1&_device=iPhone&A54EF499-4F79-467A-B540-F89104B82D23&2.4.60; net-mode=WIFI; channel=ios-appstore; country_id=2; x-mulehorse-bucketIds=,; domain=api.himalaya.com; impl=com.ximalaya.xmlyi; locale=en_US; path=/; idfa=A54EF499-4F79-467A-B540-F89104B82D23; x-abtest-bucketIds=316418; JSESSIONID=DADF38BA83E0E26314D5DAD39EBDF817; 1&_token=1316043&1dbd3a070aff70418808ddb0f49b9bcd1a6b; c-oper=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8")
                .contentType("application/json").

                when()  //执行
                .get("https://api.himalaya.com/hipoints-web/trade/user/album/unactive/v4?countryId=2&device=iPhone&scale=3&version=2.4.60").

                then().log().all()
                .statusCode(200)
                .body("ret",equalTo(0))
        ;
    }

}
