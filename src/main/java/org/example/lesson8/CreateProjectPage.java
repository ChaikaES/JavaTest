package org.example.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateProjectPage {
    final static String crmProjectNameXpath = "//input[contains(@id, 'crm_project_name')]";
    final static String allOrganizationsOptionXpath = "//div[text()='«Все организации»']";
    final static String contactOptionXpath = "//div[text()='123 123']";

    private SelenideElement crmProjectNameInput = $(By.xpath(crmProjectNameXpath));

    private SelenideElement organizationInput = $(By.xpath("//span[text()='Укажите организацию']"));

    private SelenideElement allOrganizationsOption = $(By.xpath(allOrganizationsOptionXpath));

    public SelenideElement selectBusinessUnit = $(By.xpath("//select[@name='crm_project[businessUnit]']"));

    public SelenideElement selectCurator = $(By.xpath("//select[@name='crm_project[curator]']"));

    public SelenideElement selectRp = $(By.xpath("//select[@name='crm_project[rp]']"));

    public SelenideElement selectAdministrator = $(By.xpath("//select[@name='crm_project[administrator]']"));

    public SelenideElement selectManager = $(By.xpath("//select[@name='crm_project[manager]']"));

    public SelenideElement selectContact = $(By.xpath("//div[contains(@id, 'contactMain')]/a/span"));

    private SelenideElement contactOption = $(By.xpath(contactOptionXpath));

    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]"));


    public CreateProjectPage setProjectName(String projectName) {
        crmProjectNameInput.sendKeys(projectName);
        return this;
    }

    @Step("Указать организацию")
    public CreateProjectPage setOrganization() {
        organizationInput.click();
        allOrganizationsOption.click();
        return this;
    }

    @Step("Выбрать Бизнес")
    public CreateProjectPage setBusinessUnit(String option) {
        selectBusinessUnit.selectOptionContainingText(option);
        return this;
    }

    @Step("Выбрать куратора")
    public CreateProjectPage setCurator(String option) {
        selectCurator.selectOptionContainingText(option);
        return this;
    }

    @Step("Выбрать rP")
    public CreateProjectPage setRp(String option) {
        selectRp.selectOptionContainingText(option);
        return this;
    }

    @Step("Выбрать администратора")
    public CreateProjectPage setAdministrator(String option) {
        selectAdministrator.selectOptionContainingText(option);
        return this;
    }

    @Step("Выбрать менеджера")
    public CreateProjectPage setManager(String option) {
        selectManager.selectOptionContainingText(option);
        return this;
    }

    @Step("Создать запись контакта")
    public CreateProjectPage setContact() throws InterruptedException {
        Thread.sleep(1000);
        selectContact.click();
        contactOption.click();
        return this;
    }

    @Step("Нажать кнопку Сохранить и закрыть")
    public AllProjectsPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return new AllProjectsPage();
    }

    public SelenideElement successfullCreate = $(By.xpath("//h1[contains(text(),'Проекты')]"));
}
