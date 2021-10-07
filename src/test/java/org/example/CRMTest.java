package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    final String CRM_URL = "https://crm.geekbrains.space";
    final String PROJECT_NAME = "MoNameR1";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1853, 1053));

        webDriverWait = new WebDriverWait(driver, 10);
        driver.get(CRM_URL);
        login();
    }

    @AfterEach
    void closeBrowser(){
        driver.quit();
    }

    public void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @Test
    void createProjectTest() throws InterruptedException {

        WebElement navElement = driver.findElement(By.xpath("//a/span[.='Проекты']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(navElement).build().perform();
        driver.findElement(By.xpath("//span[.='Мои проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));

        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_project_name')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys(PROJECT_NAME);

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Select selectBusinessUnit = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select selectCurator = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        selectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select selectRp = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        selectRp.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select selectAdministrator = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
        selectAdministrator.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

        Select selectManager = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        selectManager.selectByVisibleText("Юзеров Юзер");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]/a/span")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='123 123']")));
        driver.findElement(By.xpath("//div[text()='123 123']")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(10000);

    }

    @Test
    void createCardTest() throws InterruptedException {

        WebElement navElement = driver.findElement(By.xpath("//a/span[.='Контрагенты']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(navElement).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")).sendKeys("Ivanov");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_contact_firstName')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_firstName')]")).sendKeys("Stepan");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_contact_jobTitle')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_jobTitle')]")).sendKeys("Jober");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(10000);
    }

}
