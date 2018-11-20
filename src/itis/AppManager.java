package itis;

import itis.helper.LoginHelper;
import itis.helper.NavigationHelper;
import itis.helper.NewIssueHelper;
import itis.helper.NewRepositoryHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private NavigationHelper navigation;
    private LoginHelper auth;
    private NewRepositoryHelper order;
    private NewIssueHelper issueHelper;

    private static ThreadLocal<AppManager> app = new ThreadLocal<>();

    public AppManager() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "https://www.katalon.com/";
        verificationErrors = new StringBuffer();
        navigation = new NavigationHelper(this, baseUrl);
        auth = new LoginHelper(this);
        order = new NewRepositoryHelper(this);
        issueHelper = new NewIssueHelper(this);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public NewRepositoryHelper getOrder() {
        return order;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public NewIssueHelper getIssueHelper() {
        return issueHelper;
    }
}
