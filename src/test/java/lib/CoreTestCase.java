package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;


    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrate();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();

        super.tearDown();
    }
    protected void rotateScreenPortrate()
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }

    }
    protected void rotateScreenLandscape()
    {
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        }else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
     protected void backgroundApp(int seconds)
     {
         if (driver instanceof AppiumDriver){
             AppiumDriver driver = (AppiumDriver) this.driver;
             driver.runAppInBackground(Duration.ofSeconds(seconds));
         }else {
             System.out.println("Method rotateScreenPortrait() does nothing for platform" + Platform.getInstance().getPlatformVar());
         }
     }

     protected void openWikiWebPageForMobileWeb()
     {
         if(Platform.getInstance().isMW()){
             driver.get("https://en.m.wikipedia.org");
         } else {
             System.out.println("Method openWikiPageForMobileWeb() do nothing for platform" + Platform.getInstance().getPlatformVar());
         }
     }

     private void skipWelcomePageForIOSApp()
     {
         if(Platform.getInstance().isIOS()){
             AppiumDriver driver = (AppiumDriver) this.driver;
             WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
             WelcomePageObject.clickSkip();
         }
     }


}
