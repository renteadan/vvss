package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.AdminPage;

public class ChangeInfoSteps {
	AdminPage adminPage;

	@Step
	public String changeName(String name) {
		adminPage.goToInfoPage();
		adminPage.setName(name);
		adminPage.clickSave();
		return adminPage.getName();
	}
}
