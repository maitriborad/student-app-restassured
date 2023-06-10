package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteStudent() {
        Response response = given()
                .pathParams("id", "1")
                .when()
                .delete("/{id}");
        response.prettyPrint();
    }
}
