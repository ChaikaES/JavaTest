import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.lesson8.*;

public class CreatePage {
    @Given("I am autorized")
    public void iAmAutorized() {
        new LoginPage().login("Applanatest1", "Student2020!");
    }

    @Given("I hover nav menu")
    public void iHoverNavMenu() {
        new MainPage().navigationMenu.openNavigationSubMenuItems("Проекты");
    }

    @And("I click my project")
    public void iClickMyProject() {
        new ProjectsSubMenu().clickMyProjectsButton();
    }

    @And("I click create project button")
    public void iClickCreateProjectButton() {
        new MyProjectsPage().clickCreateProjectButton();
    }

    @Given("I am at creation project page")
    public void iAmAtCreationProjectPage() {
    }

    @When("I fill project name")
    public void iFillProjectName() {
    }

    @And("I select Organization")
    public void iSelectOrganization() {
    }

    @And("I select BusinessUnit")
    public void iSelectBusinessUnit() {
    }

    @And("I select Curator")
    public void iSelectCurator() {
    }

    @And("I select Rp")
    public void iSelectRp() {
    }

    @And("I select Administrator")
    public void iSelectAdministrator() {
    }

    @And("I select Manager")
    public void iSelectManager() {
    }

    @And("I select Contact")
    public void iSelectContact() {
    }

    @And("I click Save And Close Button")
    public void iClickSaveAndCloseButton() {
    }

    @Then("I can see all Projects Page")
    public void iCanSeeAllProjectsPage() {
    }
}
