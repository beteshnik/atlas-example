package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.*;

//кнопки
public interface Button extends AtlasWebElement {
    @FindBy("//button[contains(@class='btn-primary')][not(@disabled)][text()='{{name}}']")
    AtlasWebElement button(@Param("name") String value);

}