package com.epam.api.utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginTokenGenerator {
    public static String getTokenOnLogin(){
        Response response = given()
                .contentType("application/json")
                .body("{\"username\":\"admin\",\"password\":\"admin\",\"rememberMe\":false}")
                .post("http://localhost:9000/api/authenticate");

        return response.path("id_token");
    }
}
