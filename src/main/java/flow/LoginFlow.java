package flow;

import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pagesOld.LoginPage;
import java.io.IOException;

public class LoginFlow {

    private static LoginPage loginPage = PageFactory.initElements(
            Browser.getDriver(), LoginPage.class
    );

    //Открываем LoginPage
    public static void openHomePage() {
        loginPage.openHomePage();
    }

    //Успешная авторизация
    public static void login(String login, String password) throws IOException {
        loginPage.ensurePageLoaded();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.submitButtonClick();
    }

}