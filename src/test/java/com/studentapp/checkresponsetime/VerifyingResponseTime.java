package com.studentapp.checkresponsetime;

import com.studentapp.testbase.TestBase;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class VerifyingResponseTime extends TestBase {

    @Test
    public void test001() {
        long responseTime=given()
                .when()
                .get("/list")
                .time();
        System.out.println(responseTime);

        given()
                .when()
                .get("/list")
                .then()
                .time(lessThan(6000L), TimeUnit.MILLISECONDS);
    }
}
