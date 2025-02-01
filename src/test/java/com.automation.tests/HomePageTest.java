package com.automation.tests;

import com.automation.framework.base.BaseTest;
import com.automation.framework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.getTitle();
        Assert.assertTrue(title.contains("გალერია თბილისი"));
    }
}
