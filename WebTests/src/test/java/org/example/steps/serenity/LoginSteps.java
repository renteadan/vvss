package org.example.steps.serenity;


import net.thucydides.core.annotations.Step;
import org.example.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    public void inputPassword(String password) {
        loginPage.inputPassword(password);
    }

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
