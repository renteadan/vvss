package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.steps.serenity.ChangeInfoSteps;
import org.example.steps.serenity.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/infoData.csv")
public class ChangeInfoTest {

	@Managed
	private WebDriver webdriver;
	@Steps
	private ChangeInfoSteps steps;
	@Steps
	private LoginSteps loginSteps;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username, password;

	@Test
	public void loginTest() {
		loginSteps.login(username, password);
		String name = RandomStringUtils.randomAlphabetic(12);
		String newName = steps.changeName(name).split(" ")[0];
		assert newName.equals(name);
	}

}
