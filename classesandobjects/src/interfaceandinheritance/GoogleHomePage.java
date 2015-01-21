package interfaceandinheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by harshkumar on 1/20/15.
 */
public class GoogleHomePage implements Page {
    //Using interface WebDrivver and not a specific implementation

    private WebDriver webDriver;
    private By searchBox = By.name("q");

    public GoogleHomePage (final WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Override
    public void search(final String testData) {
        System.out.println("##############################");
        System.out.println("##############################");
        System.out.println("Search on google home page, search data: " + testData);

        webDriver.findElement(searchBox).clear();


        webDriver.findElement(searchBox).sendKeys(testData);
    }

}
