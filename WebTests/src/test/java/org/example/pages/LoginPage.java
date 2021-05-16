package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://orangehrm-demo-6x.orangehrmlive.com/auth/login")
public class LoginPage extends PageObject {

    @FindBy(id = "txtUsername")
    private WebElement userInput;
    @FindBy(id = "txtPassword")
    private WebElement passwordInput;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void typeUser(String username) {
        userInput.clear();
        userInput.sendKeys(username);
    }
}
