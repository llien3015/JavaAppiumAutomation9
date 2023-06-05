package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject
{
    static
    {
               FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
               ARTICLE_BY_TITLE_TPL = "xpath://*[@text='Java (programming language)']";
        LIST_BY_NAME_XPATH_TPL = "xpath://*[@text='{LIST_NAME}']";
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
