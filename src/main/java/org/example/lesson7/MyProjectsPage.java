package org.example.lesson7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProjectsPage extends BaseView {
    final static String createProjectButtonXPath = "//a[.='Создать проект']";

    @FindBy(xpath = createProjectButtonXPath)
    public WebElement createProjectButton;

    public MyProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Создать проект")
    public CreateProjectPage clickCreateProjectButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createProjectButtonXPath)));
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateProjectPage.crmProjectNameXpath)));

        return new CreateProjectPage(driver);
    }
}
