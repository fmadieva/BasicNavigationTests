package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {

    public static void Chrome(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String chromeTitle = driver.getTitle();
        driver.get("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(chromeTitle,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(etsyTitle,driver.getTitle());

        driver.close();
    }

    public static void FireFox(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title1,driver.getTitle());

        driver.close();
    }

    public static void Safari(){
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.get("https://etsy.com");
        String title1 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(title,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(title1,driver.getTitle());

        driver.close();
    }

    public static void main(String[] args) {
        Chrome();
        FireFox();
        Safari();

    }
}
