package itis.helper;

import itis.AppManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected AppManager manager;
    protected WebDriver driver;

    protected boolean acceptNextAlert = true;

    public HelperBase(AppManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }
}
