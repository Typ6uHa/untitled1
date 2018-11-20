package itis.helper;

import itis.AppManager;
import itis.model.Issue;
import org.openqa.selenium.By;

public class NewIssueHelper extends HelperBase {

    public NewIssueHelper(AppManager manager) {
        super(manager);
    }

    public void newIssie(Issue issue) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Overview'])[1]/following::a[1]")).click();
        driver.findElement(By.linkText("Testing23fhtyfjhgbj4")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Code'])[1]/following::span[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='good first issue'])[1]/following::a[1]")).click();
        driver.findElement(By.id("issue_title")).clear();
        driver.findElement(By.id("issue_title")).sendKeys(issue.getTitle());
        driver.findElement(By.id("issue_body")).click();
        driver.findElement(By.id("issue_body")).clear();
        driver.findElement(By.id("issue_body")).sendKeys(issue.getDescription());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Try again.'])[1]/following::button[1]")).click();
    }

    public Issue getCreatedIssue() {
        String title;
        String description;
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Overview'])[1]/following::a[1]")).click();
        driver.findElement(By.linkText("Testing23fhtyfjhgbj4")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Issues'])[2]/following::span[1]")).click();
        title = driver.findElement(By.id("issue-id-4")).getText();
        driver.findElement(By.id("issue-id-4")).click();
        description = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Typ6uHa'])[4]/following::p[1]")).getText();
        return new Issue(title, description);
    }
}
