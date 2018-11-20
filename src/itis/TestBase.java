package itis;

import static org.junit.Assert.fail;

public class TestBase {

    protected AppManager manager;

    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "Z://geckodriver.exe");
        manager = new AppManager();
    }

    public void tearDown() throws Exception {
        manager.getDriver().quit();
        String verificationErrorString = manager.getVerificationErrors().toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
