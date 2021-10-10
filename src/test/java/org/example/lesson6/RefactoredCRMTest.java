package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RefactoredCRMTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    final String CRM_URL = "https://crm.geekbrains.space";
    final String PROJECT_NAME = "MoNameR9";

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

        new LoginPage(driver).fillLogin("Applanatest1").fillPassword("Student2020!").sendLogin();
    }

    @AfterEach
    void closeBrowser(){
        driver.quit();
    }

    @Test
    void createProjectTest() {

    }
}


