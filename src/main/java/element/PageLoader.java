package element;

import common.Application;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

import java.util.concurrent.TimeUnit;

import static common.Browser.getDriver;

//спиннер загрузки
public interface PageLoader extends AtlasWebElement {

    int periodElementWait = Integer.parseInt(Application.getProperty("periodElementWait"));
    int periodInvisibleWait = Integer.parseInt(Application.getProperty("periodInvisibleWait"));

    @FindBy("//div[@id='loader']")
    AtlasWebElement loader();

    default void ensureLoaderDisapper(){
        int counter = 0, second = 1; // интервал проверки

        getDriver().manage().timeouts().implicitlyWait(periodInvisibleWait, TimeUnit.SECONDS);
        try {
            while (loader().isDisplayed()) {
                Thread.sleep(second * 1000);
                counter += second;
                System.out.println(counter);
                if (counter > periodElementWait)
                    throw new RuntimeException("Страница не загрузилась спустя (sec): " + periodElementWait);
            }
        } catch (Exception e) {
        }
    }

}