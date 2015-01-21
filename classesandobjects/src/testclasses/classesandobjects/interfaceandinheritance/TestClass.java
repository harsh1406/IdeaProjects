package testclasses.classesandobjects.interfaceandinheritance;

import interfaceandinheritance.Browser;
import interfaceandinheritance.GoogleHomePage;
import interfaceandinheritance.GoogleSearchResultPage;
import interfaceandinheritance.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by harshkumar on 1/21/15.
 */
public class TestClass {
    private WebDriver webDriver;
    /**
     * initialize driver
     * @param browser
     */

    public void initDriver(final Browser browser) {
        switch (browser) {
            case Chrome :

                //assign object to type interface and not specific implementation

                webDriver = new ChromeDriver();
                break;

            case FF :
                webDriver = new FirefoxDriver();
                break;

            case IE :
                webDriver = new InternetExplorerDriver();
                break;

            default:
                System.out.println("Invalid Browser!!!");

        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * launch web application
     */

    public void launchApp() {
        webDriver.get("http://www.google.com/");
    }

    /**
     * shut down driver
     */

    public void shutDownDriver() {
        webDriver.close();
        webDriver.quit();
    }


    public void searchOnGoogleHomePage (final String testData) {
        //invalid, an interface can not be instantiated since its incomplete
        //Page page = new Page();

        //assign object to type interface and not specific implementation

        Page googleHomePage = new GoogleHomePage(webDriver);

        //search on homepage
        googleHomePage.search(testData);
    }

    public String getSearchResultStatistics() {
        System.out.println("###########################");
        System.out.println("###########################");
        System.out.println("calling method specific to GoogleSearchResultPage");

        Page page = new GoogleSearchResultPage(webDriver);
        String searchResultStatistics = null;

        //Check if page is instance of GoogleSearchResultPage
        if (page instanceof GoogleSearchResultPage) {
            searchResultStatistics = ((GoogleSearchResultPage) (page)).getResultSet();
        }
        return searchResultStatistics;
    }

    public static void main(final String[] args) {
        TestClass testClass = new TestClass();
        Browser browser = Browser.FF;
        testClass.initDriver(browser);
        testClass.launchApp();

        testClass.searchOnGoogleHomePage("Black box testing");
        testClass.searchOnGoogleHomePage("White Box testing");
        System.out.println("Result set is:" + testClass.getSearchResultStatistics());

        testClass.shutDownDriver();
    }
}

