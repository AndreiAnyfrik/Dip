package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.teachmeskills.page.LoginPage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginNegativeTest extends BaseTest {

    @Test
    public void logWithIncorrectUserNameAndPassword() {
        String expectedError = "Login failed";
        String errorInvalidUserNameAndInvalidPassword = new LoginPage(driver).open().loginWithIncorrectLoginAndPassword()
                .getErrorInvalidUserNameAndInvalidPassword();
        assertThat(errorInvalidUserNameAndInvalidPassword)
                .isEqualTo(expectedError).
                as(" " + expectedError + "is not displayed after log in with invalid user name and password");

    }

    @Test
    public void logWithoutPassword() {
        String expectedError = "Mandatory field";
        String errorEmptyPassword = new LoginPage(driver).open().loginWithIncorrectLoginAndEmptyPassword()
                .getErrorEmptyPassword();
        assertThat(errorEmptyPassword)
                .isEqualTo(expectedError)
                .as(" " + expectedError + "is not displayed after log in without password");
    }

    @Test
    public void logWithEmptyFields() {
        String expectedError = "Mandatory field";
        String errorAfterEmptyPassword = new LoginPage(driver).open().loginWithEmptyFields().getErrorEmptyPassword();
        assertThat(errorAfterEmptyPassword)
                .isEqualTo(expectedError)
                .as(" " + expectedError + "is not displayed after log in with empty fields");
        String errorAfterEmptyPassword1 = new LoginPage(driver).getErrorEmptyLogin();
        assertThat(errorAfterEmptyPassword1)
                .isEqualTo(expectedError)
                .as(" " + expectedError + "is not displayed after log in with empty fields");
    }
}




