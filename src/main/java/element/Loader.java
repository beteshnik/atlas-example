package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

//спиннер загрузки
public interface Loader extends AtlasWebElement {
    @FindBy("//div[@id='loader']")
    AtlasWebElement loader();

}