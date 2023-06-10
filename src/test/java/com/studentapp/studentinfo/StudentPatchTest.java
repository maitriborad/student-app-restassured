package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail(TestUtils.getRandomValue() + "MB@gmail.com");

        Response response= given()
                .header("Content-Type", "application/json")
                .pathParams("id", "1")
                .when()
                .body(studentPojo)
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
