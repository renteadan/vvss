package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://filelist.io/login.php?returnto=%2F")
public class LoginPage extends PageObject {
    @FindBy(id = "username")
    private WebElement userInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(className = "btn")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void typeUser(String username) {
        userInput.sendKeys(username);
    }
}
