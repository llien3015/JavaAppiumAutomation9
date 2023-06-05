package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI
{
    static {
        MY_LISTS_LINK = "xpath://XCUIElementTypeButton[@name='Saved']";
        MY_LISTS_LINK2 = "xpath://XCUIElementTypeButton[@name='Close']";

    }

    public iOSNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
