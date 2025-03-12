import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class AuthenticationTests {
    RequestSpecification requestSpecification;

    // GitHub Personal Access Token (PAT) for OAuth2 authentication, fetched from environment variable
    private final String personalAccessToken = System.getenv("PERSONAL_TOKEN");

    // GitHub username, fetched from environment variable (or configurable via test data)
    private final String expectedUsername = System.getenv("GITHUB_USERNAME");

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://api.github.com/user";

        requestSpecification = RestAssured.given();
    }

    public Response sendAuthenticatedRequest(){
        return requestSpecification
                .auth()
                .oauth2(personalAccessToken)
                .when()
                .get()
                .then()
                .extract().response();
    }

    @Test
    public void testAuthenticationResponse(){
        Response response = sendAuthenticatedRequest();

        response
                .then()
                .statusCode(200)
                .body("login", equalTo(expectedUsername));
    }

}
