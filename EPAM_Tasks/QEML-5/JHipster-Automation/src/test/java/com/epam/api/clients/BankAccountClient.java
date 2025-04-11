package com.epam.api.clients;

import com.epam.api.config.APIConfigReader;
import com.epam.api.models.BankAccount;
import com.epam.api.utils.LoginTokenGenerator;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BankAccountClient {
    static final String accountsUrl = APIConfigReader.getProperty("accounts_url");
    String token = LoginTokenGenerator.getTokenOnLogin();

    RequestSpecification requestSpecification = RestAssured
            .given()
            .baseUri(accountsUrl)
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + token);

    public Response createNewBankAccount(BankAccount bankAccount){
        return requestSpecification
                .body(bankAccount)
                .when()
                .post();
    }

    public Response getBankAccount(int ID){
        return requestSpecification
                .when()
                .get(accountsUrl+"/"+ID);
    }

    public Response updateBankAccount(int ID, BankAccount bankAccount){
        return requestSpecification
                .body(bankAccount)
                .when()
                .put(accountsUrl+"/"+ID);
    }

    public Response patchBankAccount(int ID, BankAccount bankAccount){
        return requestSpecification
                .body(bankAccount)
                .when()
                .patch(accountsUrl+"/"+ID);
    }

    public Response deleteBankAccount(int ID){
        return requestSpecification
                .when()
                .delete(accountsUrl+"/"+ID);
    }

    public Response getAllBankAccounts(){
        return requestSpecification
                .when()
                .get();
    }
}
