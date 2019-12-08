package layout;

import io.qameta.atlas.webdriver.extension.FindBy;
import element.PageLoader;

//слой со спиннером
public interface WithLoader  {
    @FindBy("//body")
    PageLoader loader();

}