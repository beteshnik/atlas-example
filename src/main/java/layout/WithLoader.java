package layout;

import io.qameta.atlas.webdriver.extension.FindBy;
import element.Loader;

//слой со спиннером
public interface WithLoader  {
    @FindBy("//body")
    Loader loader();

}