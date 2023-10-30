package tests;


import io.qameta.allure.Lead;
import io.restassured.response.Response;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import specs.TaggingsSpec;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.AuthenticationSpec.*;
import static specs.PagesSpec.pagesRequestSpec;
import static specs.PagesSpec.pagesResponse201Spec;
import static specs.TaggingsSpec.*;
import static specs.TagsSpec.*;

public class FeedbinTests extends TestBase {

    @CsvFileSource(resources = "/credentials.csv")
    @DisplayName("Positive auth")
    @ParameterizedTest(name = "Positiv login.  Email: {0} and password: {1}")
    void successfulAuthTest(String user, String password) {
       Response response = step("Make authentication request", () ->
                given(authRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .when()
                        .get("/authentication.json")
                        .then()
                        .spec(authResponse200Spec))
                        .extract().response();

        step("Verify response", () ->
                assertEquals("application/json", response.getContentType()));
    }

    @CsvFileSource(resources = "/negative_credentials_wrong_email.csv")
    @DisplayName("Negative auth. Wrong email")
    @ParameterizedTest(name = "Negativ auth {0}.  Email: {1} and password: {2}")
    void negativeAuthWrongEmailTest(String user, String password) {
        Response response = step("Make authentication request", () ->
                given(authRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .when()
                        .get("/authentication.json")
                        .then()
                        .spec(authResponse401Spec))
                .extract().response();

        step("Verify response", () ->
                assertEquals("HTTP Basic: Access denied.\n", response.getBody().asString()));
    }

    @CsvFileSource(resources = "/negative_credentials_wrong_password.csv")
    @DisplayName("Negative auth. Wrong password")
    @ParameterizedTest(name = "Negativ auth {0}.  Email: {1} and password: {2}")
    void negativeAuthWrongPasswordTest(String user, String password) {
        Response response = step("Make authentication request", () ->
                given(authRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .when()
                        .get("/authentication.json")
                        .then()
                        .spec(authResponse401Spec))
                .extract().response();

        step("Verify response", () ->
                assertEquals("HTTP Basic: Access denied.\n", response.getBody().asString()));
    }

    @CsvFileSource(resources = "/credentials.csv")
    @DisplayName("Create a new entry")
    @ParameterizedTest(name = "Positiv login. Create a new entry")
    void pagesTest(String user, String password) {
        PagesBodyModel pagesBody = new PagesBodyModel();
        pagesBody.setUrl("https://feedbin.com/blog/2018/09/11/private-by-default/");
        pagesBody.setTitle("Private by Default");

        PagesResponseModel response = step("Make new page request", () ->
                given(pagesRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .body(pagesBody)
                        .when()
                        .post("/pages.json")
                        .then()
                        .spec(pagesResponse201Spec)
                        .extract().as(PagesResponseModel.class));

        step("Verify response", () -> {
            assertEquals("4262240110", response.getId());
            assertEquals("2754457", response.getFeedId());
        });
    }
}
