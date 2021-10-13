package org.example.lesson7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView {
    final static String crmProjectNameXpath = "//input[contains(@id, 'crm_project_name')]";
    final static String allOrganizationsOptionXpath = "//div[text()='«Все организации»']";
    final static String contactOptionXpath = "//div[text()='123 123']";

    @FindBy(xpath = crmProjectNameXpath)
    public WebElement crmProjectNameInput;

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement organizationInput;

    @FindBy(xpath = allOrganizationsOptionXpath)
    public WebElement allOrganizationsOption;

    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    public WebElement selectBusinessUnit;

    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    public WebElement selectCurator;

    @FindBy(xpath = "//select[@name='crm_project[rp]']")
    public WebElement selectRp;

    @FindBy(xpath = "//select[@name='crm_project[administrator]']")
    public WebElement selectAdministrator;

    @FindBy(xpath = "//select[@name='crm_project[manager]']")
    public WebElement selectManager;

    @FindBy(xpath = "//div[contains(@id, 'contactMain')]/a/span")
    public WebElement selectContact;

    @FindBy(xpath = contactOptionXpath)
    public WebElement contactOption;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public CreateProjectPage setProjectName(String projectName) {
        crmProjectNameInput.sendKeys(projectName);
        return this;
    }

    @Step("Указать организацию")
    public CreateProjectPage setOrganization() {
        organizationInput.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(allOrganizationsOptionXpath)));
        allOrganizationsOption.click();
        return this;
    }

    @Step("Выбрать Бизнес")
    public CreateProjectPage setBusinessUnit(String businessUnit) {
        new Select(selectBusinessUnit).selectByVisibleText(businessUnit);
        return this;
    }

    @Step("Выбрать куратора")
    public CreateProjectPage setCurator(String curator) {
        new Select(selectCurator).selectByVisibleText(curator);
        return this;
    }

    @Step("Выбрать rP")
    public CreateProjectPage setRp(String rP) {
        new Select(selectRp).selectByVisibleText(rP);
        return this;
    }

    @Step("Выбрать администратора")
    public CreateProjectPage setAdministrator(String administrator) {
        new Select(selectAdministrator).selectByVisibleText(administrator);
        return this;
    }

    @Step("Выбрать менеджера")
    public CreateProjectPage setManager(String manager) {
        new Select(selectManager).selectByVisibleText(manager);
        return this;
    }

    @Step("Создать запись контакта")
    public CreateProjectPage setContact() throws InterruptedException {
        Thread.sleep(1000);
        selectContact.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactOptionXpath)));
        contactOption.click();
        return this;
    }

    @Step("Нажать кнопку Сохранить и закрыть")
    public AllProjectsPage clickSaveAndCloseButton() throws InterruptedException {
        saveAndCloseButton.click();
        Thread.sleep(10000);
        return new AllProjectsPage(driver);
    }
}
