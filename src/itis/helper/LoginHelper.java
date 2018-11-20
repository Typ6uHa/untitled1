package itis.helper;

import itis.AppManager;
import itis.model.AccountStruct;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public LoginHelper setEmail(String login) {
        driver.findElement(By.id("login_field")).click();
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(login);
        return this;
    }

    public void setPassword(String password) {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    public void setEmailWithValidAllFields(AccountStruct user) {
        setEmail(user.getLogin()).setPassword(user.getPassword());
    }

    public void login(AccountStruct user) {
        setEmailWithValidAllFields(user);
    }
}
