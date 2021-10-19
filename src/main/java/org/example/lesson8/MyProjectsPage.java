package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

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
