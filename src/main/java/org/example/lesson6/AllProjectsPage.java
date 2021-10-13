package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjectsPage extends BaseView {

    @FindBy(xpath = "//h1[contains(text(),'Проекты')]")
    public WebElement header;

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }
}
