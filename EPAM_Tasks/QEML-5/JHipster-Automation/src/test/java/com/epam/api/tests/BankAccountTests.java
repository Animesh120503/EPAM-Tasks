package com.epam.api.tests;

import com.epam.api.clients.BankAccountClient;
import com.epam.api.models.BankAccount;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static com.epam.api.utils.ResponseValidator.*;
import static org.hamcrest.Matchers.equalTo;

public class BankAccountTests {
    int ID;
    String NAME;

    BankAccountClient bankAccountClient;
    BankAccount defaultBankAccount;

    File BankAccountSchemaFile = new File("src/main/resources/api/schemas/BankAccountDetailSchema.json");

    @BeforeClass
    public void setup() {
        bankAccountClient = new BankAccountClient();
        defaultBankAccount = BankAccount.createDefaultBankAccount();
    }

    @Test
    public void testCreateBankAccountWithValidData() {

        Response response = bankAccountClient.createNewBankAccount(defaultBankAccount);

        validateBasicPostRequest(response, 201)
                .body("balance", equalTo(4500.0F))
                .body("name", equalTo("User 3"));

        ID = response.path("id");
        NAME = response.path("name");
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 1)
    public void testGetBankAccountDetailsWithValidId() {

        Response response = bankAccountClient.getBankAccount(ID);

        validateBasicGetRequestAlongWithSchema(response, 200, BankAccountSchemaFile)
                .body("name", equalTo(NAME))
                .body("id", equalTo(ID));
    }

    @Test
    public void testGetBankAccountDetailsWithInvalidId() {

        Response response = bankAccountClient.getBankAccount(1002);

        validateBasicGetRequest(response, 404);
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 1)
    public void testUpdateBankAccountDetailsWithValidData_PositiveBalance() {
        BankAccount updatedBankAccount = new BankAccount.Builder()
                .setId(ID)
                .setBalance(60000.0F)
                .setName("Some User")
                .setUser(null)
                .build();

        Response response = bankAccountClient.updateBankAccount(ID, updatedBankAccount);

        validateBasicUpdateRequestAlongWithSchema(response, 200, BankAccountSchemaFile)
                .body("id", equalTo(ID))
                .body("balance", equalTo(60000.0F));
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 1)
    public void testUpdateBankAccountDetailsWithValidData_NegativeBalance() {
        float negativeBalance = -60000;
        BankAccount updatedBankAccount = new BankAccount.Builder()
                .setId(ID)
                .setBalance(negativeBalance)
                .setName("Some User")
                .setUser(null)
                .build();

        Response response = bankAccountClient.updateBankAccount(ID, updatedBankAccount);

        validateBasicUpdateRequestAlongWithSchema(response, 200, BankAccountSchemaFile)
                .body("balance", equalTo(-60000.0F));
    }

    @Test
    public void testUpdateBankAccountDetailsWithInvalidData() {
        int invalidEndpoint = 1002;
        Response response = bankAccountClient.getBankAccount(invalidEndpoint);

        validateBasicUpdateRequest(response, 404);
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 2)
    public void testDeleteBankAccountWithValidID() {
        Response response = bankAccountClient.deleteBankAccount(ID);

        validateBasicDeleteRequest(response);
    }

    @Test
    public void testGetAllBankAccounts() {
        Response response = bankAccountClient.getAllBankAccounts();

        validateBasicGetRequestAlongWithSchema(response, 200, BankAccountSchemaFile);
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 1)
    public void testUpdateBankAccountDetailsWithPATCH_ValidData() {
        String newName = "New User 5";
        BankAccount updateBankAccount = new BankAccount.Builder()
                .setId(ID)
                .setName(newName)
                .build();

        Response response = bankAccountClient.patchBankAccount(ID, updateBankAccount);

        validateBasicUpdateRequestAlongWithSchema(response, 200, BankAccountSchemaFile)
                .body("name", equalTo(newName));
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 1)
    public void testUpdateBankAccountDetailsWithPATCH_emptyId() {
        String newName = "New User 5";
        BankAccount updateBankAccount = new BankAccount.Builder()
                .setName(newName)
                .build();

        Response response = bankAccountClient.patchBankAccount(ID, updateBankAccount);

        validateBasicUpdateRequest(response, 400);
    }

    @Test(dependsOnMethods = "testCreateBankAccountWithValidData", priority = 1)
    public void testUpdateBankAccountDetailsWithPATCH_InvalidId() {
        String newName = "New User 5";
        BankAccount updateBankAccount = new BankAccount.Builder()
                .setId(1234)
                .setName(newName)
                .build();

        Response response = bankAccountClient.patchBankAccount(ID, updateBankAccount);

        validateBasicUpdateRequest(response, 400);
    }

}
