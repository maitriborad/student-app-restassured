package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {
    @Test
    public void updateAllStudentDetails() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Selenium");
        courseList.add("REST");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Maitri");
        studentPojo.setLastName("Borad");
        studentPojo.setEmail(TestUtils.getRandomValue() + "MB@gmail.com");
        studentPojo.setProgramme("API Testing");
        studentPojo.setCourses(courseList);

        Response response= given()
                .header("Content-Type", "application/json")
                .pathParams("id", "1")
                .when()
                .body(studentPojo)
                .put("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
