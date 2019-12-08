package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

//кнопки
public interface Input extends AtlasWebElement {
    @FindBy("//input[not(@disabled)][@id='{{id}}']")
    AtlasWebElement input(@Param("id") String value);

    default void fillInput(String value, String text){
        input(value).click();
        input(value).sendKeys(text);
    }

}