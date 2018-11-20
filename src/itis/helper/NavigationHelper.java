package itis.helper;

import itis.AppManager;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
    private String baseURL;

    public NavigationHelper(AppManager manager, String baseURL) {
        super(manager);
        this.baseURL = baseURL;
    }

    public void getLoginPage() {
        driver.get("https://github.com/login");
    }

    public void getMainPage(){
        driver.get("https://github.com/Typ6uHa");
    }
    public void getNewRepository() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Our new Terms of Service and Privacy Statement are in effect.'])[1]/following::a[1]")).click();
    }
}
