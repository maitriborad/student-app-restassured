package com.studentapp.loggingrequestresponse;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoggingResponseDetails {
    /**
     * This test will print out all the Response Headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");
        given().log().headers()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");
        given()
                .when()
                .get("/list")
                .then().log().status()
                .statusCode(200);
    }


    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");
        given().log().body()
                .when()
                .get("/list")
                .then().log().status()
                .statusCode(200);
    }

    /**
     * This test will print the Response in case of an error
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing Response Body in case of an error------------------");
        given().log().body()
                .when()
                .get("/list")
                .then().log().ifError()
                .statusCode(404);
    }
}
