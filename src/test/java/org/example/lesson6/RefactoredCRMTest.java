package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RefactoredCRMTest {

    final String CRM_URL = "https://crm.geekbrains.space";
    final String PROJECT_NAME = "MoNameR12";
    WebDriver driver;
    WebDriverWait webDriverWait;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1853, 1053));

        webDriverWait = new WebDriverWait(driver, 10);
        driver.get(CRM_URL);

        mainPage = new LoginPage(driver).fillLogin("Applanatest1").fillPassword("Student2020!").sendLogin();
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }

    @Test
    void createProjectTest() throws InterruptedException {
        CreateProjectPage createProjectPage = mainPage
                .navigationMenu
                .openNavigationSubMenuItems("Проекты")
                .clickMyProjectsButton()
                .clickCreateProjectButton();

        AllProjectsPage allProjectsPage = createProjectPage
                .setProjectName(PROJECT_NAME)
                .setOrganization()
                .setBusinessUnit("Research & Development")
                .setCurator("Applanatest Applanatest Applanatest")
                .setRp("Applanatest1 Applanatest1 Applanatest1")
                .setAdministrator("Applanatest2 Applanatest2 Applanatest2")
                .setManager("Юзеров Юзер")
                .setContact()
                .clickSaveAndCloseButton();

        Assertions.assertNotNull(allProjectsPage.header);

        Thread.sleep(10000);


    }
}


