package oops.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Harsh on 6:06 PM 1/14/2015.
 */
public class FirefoxSelenium {
    //Instance Variable
    String searchResult;

    //Class variable
    static String browser = "Firefox";

    public static void main(final String[] args) {
        //local variable
        int temp =0;

        FirefoxSelenium firefoxSelenium1 = new FirefoxSelenium();
        FirefoxSelenium firefoxSelenium2 = new FirefoxSelenium();

        firefoxSelenium1.searchResult = "For instance firefox selenium1";
        firefoxSelenium2.searchResult = "For instance firefox selenium2";

        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("Access instance variable");
        System.out.println("First object state"+ firefoxSelenium1.searchResult);
        System.out.println("Second object state"+ firefoxSelenium2.searchResult);

        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("Access class variable");
        System.out.println(FirefoxSelenium.browser);

        //Array
        String[] searchResultLinks = new String[2];


        FirefoxDriver firefoxDriver;
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        firefoxDriver.get("http://www.google.com");


        //method accepting by parameter

        firefoxDriver.findElement(By.name("q")).sendKeys("Selenium HQ");
        firefoxDriver.findElement(By.name("btnG")).click();


        //
        searchResultLinks[0]= firefoxDriver.findElement(By.linkText("Videos")).getText();
        searchResultLinks[1]= firefoxDriver.findElement(By.linkText("News")).getText();

        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("Access Array elements");
        System.out.println("First link result" + searchResultLinks[0]);
        System.out.println("Second Link result" + searchResultLinks[1]);


        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("Conditional flow statements");
        if (firefoxDriver.findElement(By.linkText("Videos")).isDisplayed()){
            System.out.println("Web Link is Present");
        }
        if (firefoxDriver.findElement(By.id("resultStats")).getText().equals("microsoft")){
            System.out.println("Microsoft is present");
        } else {
            System.out.println("Microsoft is not present");
        }

        System.out.println("###############################");
        System.out.println("###############################");
        System.out.println("For Loop & Break Statement");
        for (String str : searchResultLinks){
            System.out.println(str);
            if (str.equals("Videos")){
                break;
            }
        }
        System.out.println("###############################");
        System.out.println("###############################");

        firefoxDriver.close();
        firefoxDriver.quit();
    }


}