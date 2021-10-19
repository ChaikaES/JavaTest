package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

public class MyProjectsPage {
    final static String createProjectButtonXPath = "//a[.='Создать проект']";

    private SelenideElement createProjectButton = $(By.xpath(createProjectButtonXPath));

    @Step("Создать проект")
    public CreateProjectPage clickCreateProjectButton() {
        createProjectButton.click();
        return new CreateProjectPage();
    }
}
