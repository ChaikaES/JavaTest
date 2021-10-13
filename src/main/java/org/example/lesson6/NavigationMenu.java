package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenu extends BaseView {
    ProjectsSubMenu projectsSubMenu;

    public NavigationMenu(WebDriver driver) {
        super(driver);
        projectsSubMenu = new ProjectsSubMenu(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navigationMenuItems;

    public ProjectsSubMenu openNavigationSubMenuItems(String menuName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(navigationMenuItems.stream().filter(element -> element.getText().equals(menuName))
                .findFirst().get()).build().perform();
        return new ProjectsSubMenu(driver);
    }
}
