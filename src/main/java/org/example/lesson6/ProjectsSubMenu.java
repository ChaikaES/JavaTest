package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSubMenu extends BaseView{
    @FindBy(xpath = "//span[.='Мои проекты']")
    public WebElement myProjectsButton;

    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    public MyProjectsPage clickMyProjectsButton() {
        myProjectsButton.click();
        return new MyProjectsPage(driver);
    }
}
