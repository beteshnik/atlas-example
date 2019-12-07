package site;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.*;

import page.LoginPage;
import page.LoginErrorPage;
import page.MainPage;
import page.ProfilePage;

public interface Site extends WebSite {

    @Page(url = "index.html")
    LoginPage onLoginPage();

    @Page(url = "main.html")
    MainPage onMainPage();

    @Page(url = "profile.html")
    ProfilePage onProfilePage();

    @Page (url = "loginError.html")
    LoginErrorPage onLoginErrorPage();

}