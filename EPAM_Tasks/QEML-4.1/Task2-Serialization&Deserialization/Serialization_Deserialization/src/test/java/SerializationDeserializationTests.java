//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.restassured.RestAssured;
//import io.restassured.module.jsv.JsonSchemaValidator;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.example.com.Post;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.IOException;
//
//import static org.hamcrest.Matchers.equalTo;
//
//public class SerializationDeserializationTests {
//
//    // Request specification to define the base URI and content type for requests
//    RequestSpecification requestSpecification;
//
//    // Path to the JSON schema for validating the response structure
//    File postSchemaFile = new File("src/test/resources/PostSchema.json");
//
//    /**
//     * Helper method to create a new Post object with mock data.
//     * @return A new Post object.
//     */
//    public Post createNewPost() {
//        // Using the Builder pattern to construct a Post object
//        return new Post.Builder()
//                .setUserId(1)
//                .setTitle("qui est esse")
//                .setBody("est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla")
//                .build();
//    }
//
//    /**
//     * Setup method that runs before the tests. Sets up base URI and content type.
//     * - Defines the base URI for the API
//     * - Sets the content type to "application/json"
//     */
//    @BeforeClass
//    public void setup() {
//        // Set the base URI for the RestAssured requests
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
//
//        // Initialize the request specification with content type JSON
//        requestSpecification = RestAssured.given()
//                .contentType("application/json");
//    }
//
//    /**
//     * Test method to send a serialized Post request to the API.
//     * - Sends a POST request with the new Post object
//     * - Validates the status code and response body using JSON schema and specific fields
//     */
//    @Test
//    public void sendSerializedRequest() {
//        // Create a new Post object to be sent
//        Post newPost = createNewPost();
//
//        try {
//            // Send a POST request with the new Post object as the body
//            requestSpecification
//                    .when()
//                    .body(newPost)  // Send the Post object as JSON
//                    .post()  // Send the POST request
//                    .then()
//                    .statusCode(201)  // Expecting status code 201 (Created)
//                    .body("userId", equalTo(1))  // Check if userId is correct
//                    .body(JsonSchemaValidator.matchesJsonSchema(postSchemaFile));  // Validate response body using JSON schema
//        } catch (Exception e) {
//            // Handle any exception that occurs during the request and log the error
//            Assert.fail("Request failed due to: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Test method to deserialize the JSON response into a Post object and validate its properties.
//     * - Sends a GET request to retrieve a post by its ID
//     * - Deserializes the response into a Post object and validates its fields
//     */
//    @Test
//    public void deserializeJsonResponse() {
//        try {
//            // Send a GET request to retrieve post with ID 2
//            Response response = requestSpecification
//                    .get("/2")
//                    .then()
//                    .body(JsonSchemaValidator.matchesJsonSchema(postSchemaFile))  // Validate response schema
//                    .extract().response();  // Extract the response
//
//            // Convert the response body to a string
//            String jsonBody = response.getBody().asString();
//
//            // Initialize ObjectMapper to deserialize the JSON into a Post object
//            ObjectMapper objectMapper = new ObjectMapper();
//            Post post = objectMapper.readValue(jsonBody, Post.class);
//
//            // Validate the deserialized Post object using assertions
//            Assert.assertEquals(response.jsonPath().getInt("userId"), post.getUserId(), "UserId mismatch");
//            Assert.assertEquals(response.jsonPath().getString("title"), post.getTitle(), "Title mismatch");
//            Assert.assertEquals(response.jsonPath().getString("body"), post.getBody(), "Body content mismatch");
//            Assert.assertTrue(response.jsonPath().getInt("id") > 0, "Id should be greater than 0");
//
//        } catch (IOException e) {
//            // Handle deserialization exception
//            Assert.fail("Deserialization failed due to: " + e.getMessage());
//        } catch (Exception e) {
//            // Handle other exceptions
//            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
//        }
//    }
//}
//

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.example.com.Post;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class SerializationDeserializationTests {

    File postSchemaFile = new File("src/test/resources/PostSchema.json");

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
    }

    private Post createPost() {
        return new Post.Builder()
                .setUserId(1)
                .setTitle("qui est esse")
                .setBody("est rerum tempore vitae" +"\n"+
                        "nsequi sint nihil reprehenderit dolor beatae ea dolores neque" +"\n"+
                        "nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis" +"\n"+
                        "nqui aperiam non debitis possimus qui neque nisi nulla")
                .build();
    }

    @Test
    public void serializeAndDeserializeTest() throws JsonProcessingException {
        Post newPost = createPost();

        // Serialize and send post via request
        RestAssured
                .given()
                .contentType("application/json")
                .body(newPost)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema(postSchemaFile));

        // Fetch the post using its ID
        Response getResponse = RestAssured
                .given()
                .contentType("application/json")
                .when()
                .get("/2")
                .then()
                .assertThat()
                .statusCode(200) // Assert status code
                .body(JsonSchemaValidator.matchesJsonSchema(postSchemaFile))
                .extract().response();

        // Deserialize the fetched post
        ObjectMapper objectMapper = new ObjectMapper();
        Post deserializedPost = objectMapper.readValue(getResponse.getBody().asString(), Post.class);

        // Compare deserialized object to the original mock post object
        Assert.assertEquals(deserializedPost.getUserId(), newPost.getUserId(), "UserId mismatch");
        Assert.assertEquals(deserializedPost.getTitle(), newPost.getTitle(), "Title mismatch");
    }
}

