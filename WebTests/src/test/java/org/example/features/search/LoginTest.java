package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/loginData.csv")
public class LoginTest {

    @Managed
    private WebDriver webdriver;
    @Steps
    private LoginSteps loginSteps;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username, password;

    @Test
    public void loginTestSuccessful() {
        loginSteps.login(username, password);
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
