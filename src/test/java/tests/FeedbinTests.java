package tests;

import io.qameta.allure.Feature;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import models.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.AuthenticationSpec.*;
import static specs.PagesSpec.pagesRequestSpec;
import static specs.PagesSpec.pagesResponse201Spec;
import static specs.TagsSpec.*;

@Feature("Feedbin.com Tests")
public class FeedbinTests extends TestBase {

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Positive auth")
    @Tag("positive")
    public void successfulAuthTest(String user, String password) {
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
    @ParameterizedTest(name = "Negative auth {0}")
    @Tag("negative")
    public void negativeAuthWrongEmailTest(String user, String password) {
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
    @ParameterizedTest(name = "Negative auth {0}")
    @Tag("negative")
    public void negativeAuthWrongPasswordTest(String user, String password) {
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
    @ParameterizedTest(name = "Create a new entry")
    @Tag("positive")
    public void pagesTest(String user, String password) {
        PagesBodyModel pagesBody = new PagesBodyModel();
        pagesBody.setUrl("https://feedbin.com/blog/2018/09/11/private-by-default/");
        pagesBody.setTitle("Private by Default");

        PagesResponseModel response = step("Make create a new entry request", () ->
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

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Get tags")
    @Tag("positive")
    public void getTagsTest(String user, String password) {
        ArrayList<TagsModel> response = step("Make get tags request", () ->
                given(taggingsRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .when()
                        .get("/taggings.json")
                        .then()
                        .spec(taggingResponse200Spec)
                        .extract().as(new TypeRef<>() {
                        }));

        step("Verify response", () -> {
            assertEquals(7331154, response.get(response.size() - 1).getId());
        });
    }

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Create tag")
    @Tag("positive")
    public void renameTagTest(String user, String password) {
        int i = (int) System.currentTimeMillis() / 1000;
        TagsBodyModel tagsBody = new TagsBodyModel();
        tagsBody.setFeedId(2754496);
        tagsBody.setName("Tech" + i);

        TagsResponseModel response = step("Make create tag request", () ->
                given(taggingsRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .body(tagsBody)
                        .when()
                        .post("/taggings.json")
                        .then()
                        .spec(taggingResponse201Spec)
                        .extract().as(TagsResponseModel.class));

        step("Verify response", () -> {
            assertThat(response.getName()).isEqualTo("Tech" + i);
        });
    }

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Delete tag")
    @Tag("positive")
    public void deleteTagTest(String user, String password) {
        int i = (int) System.currentTimeMillis() / 1000;
        TagsBodyModel tagsBody = new TagsBodyModel();
        tagsBody.setFeedId(2754496);
        String tag = "Tech" + i;
        tagsBody.setName(tag);

        TagsResponseModel responseCreate = step("Make create tag request", () ->
                given(taggingsRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .body(tagsBody)
                        .when()
                        .post("/taggings.json")
                        .then()
                        .spec(taggingResponse201Spec)
                        .extract().as(TagsResponseModel.class));

        step("Make delete tag request", () ->
                given(taggingsRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .when()
                        .delete("/taggings/" + responseCreate.getId() + ".json")
                        .then()
                        .spec(taggingResponse204Spec));

        ArrayList<TagsModel> responseTags = step("Make get tags request", () ->
                given(taggingsRequestSpec)
                        .auth()
                        .preemptive()
                        .basic(user, password)
                        .when()
                        .get("/taggings.json")
                        .then()
                        .spec(taggingResponse200Spec)
                        .extract().as(new TypeRef<>() {
                        }));

        step("Verify response", () -> {
            assertThat(tag).doesNotContain(responseTags.get(responseTags.size() - 1).toString());
        });
    }
}
