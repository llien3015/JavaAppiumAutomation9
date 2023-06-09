package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject
{

    protected static String
          MY_LISTS_LINK,
          MY_LISTS_LINK2,
          OPEN_NAVIGATION;



    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button.", 5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find My list in navigation menu",
                    5
            );
        }
    }
    public void clickMyListsX()
    {
        this.waitForElementAndClick(
                MY_LISTS_LINK2,
                "Cannot find X to My Lists",
                15
        );
    }

}
