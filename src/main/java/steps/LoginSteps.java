package steps;

import common.Application;
import common.Browser;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import page.*;
import site.*;
import element.*;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;

import java.io.IOException;

public class LoginSteps {

    private Atlas atlas = new Atlas(new WebDriverConfiguration(Browser.getDriver()));

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(Browser.getDriver(), page);
    }

    private LoginPage onLoginPage() {
        return onPage(LoginPage.class);
    }

    //авторизация
    @Step("Log in")
    @When("Log in")
    public void login() throws IOException {
        onLoginPage().startInputPassword().click();
        onLoginPage().startInputPassword().click();
    }

}
