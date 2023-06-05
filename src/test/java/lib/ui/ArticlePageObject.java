package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
    TITLE,
            TITLE_ID_SECOND,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTION_REMOVE_FROM_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    FOLDER_IN_LISTS,
            TITLE2,
    TITLE3,
    TITLE4;


    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Cannot  find article title on page", 30);
    }

    public WebElement waitForTitleElementSecond() {
        return this.waitForElementPresent(TITLE_ID_SECOND,"Cannot find article title",5);
    }
    public WebElement waitForTitleElementIOS()
    {
        return this.waitForElementPresent(TITLE3,"Cannot  find article title on page", 30);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else  if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public String getArticleSecond() {
        WebElement title_element = waitForTitleElementSecond();
        if(Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find end of article",
                    40);
        } else if (Platform.getInstance().isIOS()){
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find end of article",
                    40);
        } else {
            this.scrollWebPageTillElementNotVisible (
                    FOOTER_ELEMENT,
                    "Cannot find end of article",
                    40);
        }
    }

    public void addArticleToMyList (String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot  find button to open article options",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot  find button option to add article to reading list",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot  find 'Go it' tip overlay",
                5
        );
        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSetValue(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

        public void addArticlesToMySaved()
        {
            if(Platform.getInstance().isMW()) {
                this.removeArticleFromSavedIfItAdded();
            }
             this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,"Cannot find option to add article to reading list",15);
        }

    public void removeArticleFromSavedIfItAdded() {
        if(this.isElementPresent(OPTION_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTION_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved after removing it from this list before"
            );
        }
    }

    public void closeArticle() {
        if ((Platform.getInstance().isIOS()) || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot find X button",
                    5
            );
        } else {
            System.out.println("Method closeArticle() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }


    public void addSecondArticleToMyList () {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot  find button to open article options",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot  find button option to add article to reading list",
                5
        );
        waitForElementAndClick(
                FOLDER_IN_LISTS,
                "Cannot find folder name",
                5
        );
    }


    public void addArticleToMyList2()
    {
        waitForElementPresent(
                TITLE2,
                "Cannot delete saved article",
                5
        );
        String title_before_delete = waitForElementAndGetAttribute(
                TITLE3,
                "text",
                "Cannot find title of article",
                15
        );
        waitForElementAndClick(
                TITLE3,
                "Cannot find title of article Automation for Apps ",
                5
        );

        String title_after_delete = waitForElementAndGetAttribute(
                TITLE4,
                "text",
                "Cannot find title of article2",
                15
        );
        Assert.assertEquals(
                "article title have been changed after open",
                title_before_delete,
                title_after_delete
        );
    }





}
