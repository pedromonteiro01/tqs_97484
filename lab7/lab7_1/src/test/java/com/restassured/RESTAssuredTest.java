package com.restassured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RESTAssuredTest {

    @Test
    void checkEndpoint() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then().assertThat()
            .statusCode(200); // assert that code status is 200
    }

    @Test
    void checkTitleWhenQueryingTODO() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos/4")
        .then().assertThat()
            .statusCode(200)
            .log().body() // easy to create log
            .and().body("title", equalTo("et porro tempora"))
            .and().body("id", equalTo(4));

    }

    @Test
    void check198And199() {
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then().assertThat()
            .statusCode(200)
            .log().body()
            .body("id", hasItems(198, 199));
    }
}
