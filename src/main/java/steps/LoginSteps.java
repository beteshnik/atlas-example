package steps;

import common.Application;
import cucumber.api.java.en.When;
import flow.LoginFlow;
import io.qameta.allure.Step;

import java.io.IOException;

public class LoginSteps {

    //авторизация
    @Step("Log in")
    @When("^Log in")
    public void login()  throws IOException {
        LoginFlow.openHomePage();
        String login = Application.getProperty("login");
        String password = Application.getProperty("password");
        LoginFlow.login(login, password);
    }

    //открытие страницы авторизации
    @Step("Open Home page")
    @When("Open Home page")
    public void openHomePage() {
        LoginFlow.openHomePage();

    }

}
