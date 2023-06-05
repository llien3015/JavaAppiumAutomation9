package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        TITLE_ID_SECOND = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#ca-watch";
        OPTION_REMOVE_FROM_MY_LIST_BUTTON = "css:#ca-watch.watched";
        FOLDER_IN_LISTS = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        TITLE2 = "xpath://XCUIElementTypeStaticText[@name='Automation for Apps']";
        TITLE3 = "id:Automation for Apps";
        TITLE4 = "xpath://XCUIElementTypeStaticText[@name='Automation for Apps']";
    }
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}