package org.example.lesson8;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSubMenu extends BaseView {
    @FindBy(xpath = "//span[.='Мои проекты']")
    public WebElement myProjectsButton;

    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Выбрать Мои проекты")
    public MyProjectsPage clickMyProjectsButton() {
        myProjectsButton.click();
        return new MyProjectsPage(driver);
    }
}
