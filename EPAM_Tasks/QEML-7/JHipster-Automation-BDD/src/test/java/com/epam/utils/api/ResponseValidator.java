package com.epam.utils.api;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.File;

public class ResponseValidator {
    public static ValidatableResponse validateBasicPostRequestAlongWithSchema(Response response, int expectedStatusCode, File schemaFile){
        return response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }

    public static ValidatableResponse validateBasicPostRequest(Response response, int expectedStatusCode){
        return response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON);
    }

    public static ValidatableResponse validateBasicGetRequestAlongWithSchema(Response response, int expectedStatusCode, File schemaFile){
        return response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }

    public static ValidatableResponse validateBasicGetRequest(Response response, int expectedStatusCode){
        return response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON);
    }

    public static ValidatableResponse validateBasicUpdateRequestAlongWithSchema(Response response, int expectedStatusCode, File schemaFile){
        return response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }

    public static ValidatableResponse validateBasicUpdateRequest(Response response, int expectedStatusCode){
        return response
                .then()
                .statusCode(expectedStatusCode)
                .contentType(ContentType.JSON);
    }

    public static ValidatableResponse validateBasicDeleteRequest(Response response){
        return response
                .then()
                .statusCode(204);
    }
}
