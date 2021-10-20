import com.codeborne.selenide.Condition;
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

    @When("I fill project name")
    public void iFillProjectName() {
        new CreateProjectPage().setProjectName("NoNoName7");
    }

    @And("I select Organization")
    public void iSelectOrganization() {
        new CreateProjectPage().setOrganization();
    }

    @And("I select BusinessUnit")
    public void iSelectBusinessUnit() {
        new CreateProjectPage().setBusinessUnit("Research & Development");
    }

    @And("I select Curator")
    public void iSelectCurator() {
        new CreateProjectPage().setCurator("Applanatest Applanatest Applanatest");
    }

    @And("I select Rp")
    public void iSelectRp() {
        new CreateProjectPage().setRp("Applanatest1 Applanatest1 Applanatest1");
    }

    @And("I select Administrator")
    public void iSelectAdministrator() {
        new CreateProjectPage().setAdministrator("Applanatest2 Applanatest2 Applanatest2");
    }

    @And("I select Manager")
    public void iSelectManager() {
        new CreateProjectPage().setManager("Юзеров Юзер");
    }

    @And("I select Contact")
    public void iSelectContact() throws InterruptedException {
        new CreateProjectPage().setContact();
    }

    @And("I click Save And Close Button")
    public void iClickSaveAndCloseButton() {
        new CreateProjectPage().clickSaveAndCloseButton();
    }

    @Then("I can see all Projects Page")
    public void iCanSeeAllProjectsPage() {
        new CreateProjectPage().successfullCreate.shouldBe(Condition.visible);
    }
}
