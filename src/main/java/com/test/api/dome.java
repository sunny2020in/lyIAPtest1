package com.test.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class dome {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://baidu.com";
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }



}
