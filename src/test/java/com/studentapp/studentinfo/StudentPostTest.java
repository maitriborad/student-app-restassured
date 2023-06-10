package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
public class StudentPostTest extends TestBase {
    @Test
    public void createStudent() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Rest assured");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Maitri");
        studentPojo.setLastName("Borad");
        studentPojo.setEmail(TestUtils.getRandomValue() + "MB@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);

        Response response= given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(201);
    }

}
