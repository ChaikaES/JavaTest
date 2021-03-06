package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM1 {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1853, 1053));

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        login();

        WebElement navElement = driver.findElement(By.xpath("//a/span[.='Проекты']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(navElement).build().perform();
        driver.findElement(By.xpath("//span[.='Мои проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));

        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_project_name')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys("NameRiKo");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Select select1 = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        select1.selectByVisibleText("Research & Development");

        Select select2 = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        select2.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select select3 = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        select3.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select select4 = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
        select4.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

        Select select5 = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        select5.selectByVisibleText("Юзеров Юзер");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]/a/span")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='123 123']")));
        driver.findElement(By.xpath("//div[text()='123 123']")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(10000);

        driver.quit();
    }

    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
