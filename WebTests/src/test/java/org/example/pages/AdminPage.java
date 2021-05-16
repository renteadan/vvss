package org.example.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends PageObject {
	@FindBy(id = "menu_pim_viewMyDetails")
	private WebElement infoLink;
	@FindBy(id = "firstName")
	private WebElement nameBox;
	@FindBy(css = ".form-group .btn")
	private WebElement saveButton;
	@FindBy(id = "pim.navbar.employeeName")
	private WebElement accountNameLabel;

	public void goToInfoPage() {
		waitFor(infoLink);
		infoLink.click();
	}

	public void setName(String name) {
		waitABit(5000);
		waitFor(nameBox);
		nameBox.clear();
		nameBox.sendKeys(name);
	}

	public void clickSave() {
		saveButton.click();
		waitABit(5000);
	}

	public String getName() {
		return accountNameLabel.getAttribute("innerHTML");
	}
}
