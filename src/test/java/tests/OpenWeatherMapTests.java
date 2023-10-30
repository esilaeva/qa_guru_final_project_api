package tests;


import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.AuthenticationSpec.*;

public class OpenWeatherMapTests extends TestBase {

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

}
