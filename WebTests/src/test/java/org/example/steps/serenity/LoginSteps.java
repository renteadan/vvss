package org.example.steps.serenity;


import net.thucydides.core.annotations.Step;
import org.example.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step
    public void inputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @Step
    public void inputUser(String username) {
        loginPage.open();
        loginPage.typeUser(username);
    }

    @Step
    public void login(String username, String password) {
        inputUser(username);
        inputPassword(password);
        clickLoginButton();
    }
}
