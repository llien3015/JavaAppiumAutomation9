package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject  extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        TITLE_ID_SECOND = "id:JavaScript";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        FOLDER_IN_LISTS = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='W']";
        TITLE2 = "xpath://XCUIElementTypeStaticText[@name='Automation for Apps']";
        TITLE3 = "id:Automation for Apps";
        TITLE4 = "xpath://XCUIElementTypeStaticText[@name='Automation for Apps']";

    }

    public iOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
