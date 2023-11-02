package tests;

import annotations.Manual;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Manual
@Owner("Elena")
public class ManualTests {

    @Test
    @Tags({@Tag("positive"), @Tag("manual")})
    @Story("Authentication")
    @DisplayName("Manual test. Positive authentication")
    public void manualSuccessfulAuthTest() {
        step("Open https://feedbin.com/");
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the login field");
            step("Fill in the password field");
            step("Click on the button 'Log In'");
        });
        step("Verify: the add button has appeared");
    }

    @Test
    @Tags({@Tag("negative"), @Tag("manual")})
    @Story("Authentication")
    @DisplayName("Manual test. Negative authentication")
    public void manualNegativeAuthTest() {
        step("Open https://feedbin.com/");
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the login field email with штcorrect data ");
            step("Fill in the password field password with correct data");
            step("Click on the button 'Log In'");
        });
        step("Verify: the message 'Invalid email or password' has appeared");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("manual")})
    @Story("Working with tags")
    @DisplayName("Manual test. Delete the tag")
    public void manualDeleteTagsTest() {
        step("Open https://feedbin.com/");
        step("Log in to your account");
        step("Add the rss feed", () -> {
            step("Click on the 'Add' button");
            step("Fill in the '+ Add' field");
            step("Press 'Enter'");
        });
        step("Add a new tag for the feed", () -> {
            step("Choose the feed");
            step("Click on the 'Edit' button");
            step("Click on the '+ New Tag' button");
            step("Click on the 'Save' button");
        });
        step("Delete the tag", () -> {
            step("Choose the tag");
            step("Click on the 'Edit' button");
            step("Click on the 'Delete' button");
        });
        step("Verify: The tag has been removed");
    }
}
