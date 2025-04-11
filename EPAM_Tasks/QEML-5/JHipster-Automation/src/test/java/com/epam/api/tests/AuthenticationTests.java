package com.epam.api.tests;

import com.epam.api.clients.AuthenticationClient;
import com.epam.api.models.Authentication;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.api.utils.ResponseValidator.validateBasicPostRequest;
import static org.hamcrest.Matchers.equalTo;

public class AuthenticationTests {

    AuthenticationClient authenticationClient;
    Authentication defaultAuthenticationDetails;


    @BeforeClass
    public void setup() {
        authenticationClient = new AuthenticationClient();
        defaultAuthenticationDetails = Authentication.getDefaultAuthentication();
    }

    @Test
    public void testAuthenticationWithValidData() {

        Response response = authenticationClient.authenticate(defaultAuthenticationDetails);

        validateBasicPostRequest(response, 200);

        String token = response.path("id_token");
        Assert.assertNotNull(token, "Authorization header is null.");
    }

    @Test
    public void testAuthenticationWithWrongUsername() {

        defaultAuthenticationDetails.setUsername("Wrong Admin");

        Response response = authenticationClient.authenticate(defaultAuthenticationDetails);

        validateBasicPostRequest(response, 401)
                .body("title", equalTo("Unauthorized"));
    }

    @Test
    public void testAuthenticationWithWrongPassword() {

        defaultAuthenticationDetails.setPassword("Wrong password");

        Response response = authenticationClient.authenticate(defaultAuthenticationDetails);

        validateBasicPostRequest(response, 401)
                .body("title", equalTo("Unauthorized"));
    }
}
