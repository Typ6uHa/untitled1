package itis.helper;

import itis.AppManager;
import itis.model.RepositoryName;
import org.openqa.selenium.By;

public class NewRepositoryHelper extends HelperBase {
    public NewRepositoryHelper(AppManager manager) {
        super(manager);
    }

    public void makeRepository(RepositoryName repositoryName) throws InterruptedException {
        driver.findElement(By.id("repository_name")).click();
        driver.findElement(By.id("repository_name")).clear();
        driver.findElement(By.id("repository_name")).sendKeys(repositoryName.getText());
        Thread.sleep(10000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Nothing to show'])[2]/following::button[1]")).click();
    }

    public RepositoryName getRepositoryName(String link) {
        String name;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Overview'])[1]/following::a[1]")).click();
        name = driver.findElement(By.linkText(link)).getText();
        return new RepositoryName(name);
    }
}