package page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

//Страница логина
public interface LoginPage extends WebPage {

    @FindBy("//div[@onclick='startInputLogin()']")
    AtlasWebElement startInputLogin();

    @FindBy("//div[@onclick='startInputPassword()']")
    AtlasWebElement startInputPassword();

}