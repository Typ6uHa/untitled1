package itis.test;

import itis.TestBase;
import itis.model.AccountStruct;
import itis.model.Issue;
import itis.model.RepositoryName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Untitled extends TestBase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        AccountStruct account = new AccountStruct("Typ6uHa", "Aizat1998");
        RepositoryName repositoryName = new RepositoryName("Testing23fhtyfjhgbj4");
        Issue issue = new Issue("Test", "TestDesc");
        manager.getNavigation().getLoginPage();
        manager.getAuth().login(account);
        manager.getNavigation().getMainPage();
//        manager.getNavigation().getNewRepository();
//        manager.getOrder().makeRepository(repositoryName);
//        manager.getIssueHelper().newIssie(issue);

        Issue newIssue = manager.getIssueHelper().getCreatedIssue();

        manager.getNavigation().getMainPage();
        RepositoryName newRepositoryName = manager.getOrder().getRepositoryName("Testing23fhtyfjhgbj4");

        if (issue.getTitle().equals(newIssue.getTitle()) && issue.getDescription().equals(newIssue.getDescription())) {
            System.out.println("Ты справился, красава");
        } else {
            System.out.println("Зато ты красивый =)");
        }

        if (repositoryName.getText().equals(newRepositoryName.getText())) {
            System.out.println("Ты справился, красава");
        } else {
            System.out.println("Зато ты красивый =)");
        }
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
