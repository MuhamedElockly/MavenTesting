/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SeleniumTests/SeleneseIT.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

/**
 *
 * @author Ahmed Elrefaiy
 */
public class TestMavinIT_Organized {

    public TestMavinIT_Organized() {

    }

    @org.testng.annotations.BeforeTest
    public static void setUpClass() throws Exception {
        // initialize driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //to maximize browser window

    }

    @org.testng.annotations.AfterTest
    public static void tearDownClass() throws Exception {
//        Close the browser
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider(name = "login")
    public Object[][] dataSet1() {
        return new Object[][]{
            {"Admin", "admin123"}
        };

    }

    @DataProvider(name = "localPage")
    public Object[][] dataSet2() {
        return new Object[][]{
            {"admin Collings"}
        };

    }

    @DataProvider(name = "editableName")
    public Object[][] dp(Method method) {
        String userName = "MohamedElockly1";
        if (method.getName().equalsIgnoreCase("testSearch")) {
            return new Object[][]{
                {userName, "Mohamed123#"}
            };
        } else if (method.getName().equalsIgnoreCase("editUser")) {
            return new Object[][]{
                {userName, "Mohamed88Elockly"}
            };
        }
        if (method.getName().equalsIgnoreCase("fail")) {
            return new Object[][]{
                {userName}
            };
        } else {
            return new Object[][]{{"default"}};
        }
    }

    static WebDriver driver;

    @Test
    public void testCloseLeftSideBar() throws Exception {
        driver.findElement(By.className("bi-chevron-left")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testOpenLeftSideBar() throws Exception {
        driver.findElement(By.className("bi-chevron-right")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testPim() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/pim/viewPimModule\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(), "PIM");
    }

    @Test
    public void testLeave() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/leave/viewLeaveModule\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span")).getText(), "Leave");

    }

    @Test
    public void testTime() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/time/viewTimeModule\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[2]")).getText(), "Timesheets");
    }

    @Test
    public void testRecruitment() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/recruitment/viewRecruitmentModule\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(), "Recruitment");
    }

    @Test
    public void tesMyInfo() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/pim/viewMyDetails']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(), "PIM");
    }

    @Test
    public void testPerformance() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/performance/viewPerformanceModule\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText(), "Performance");
    }

    @Test
    public void testDashboard() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/dashboard/index\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(), "Dashboard");
    }

    @Test
    public void testDirectory() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/directory/viewDirectory\"]")).click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(), "Directory");
    }

    @Test
    public void testMaintenance() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/maintenance/viewMaintenanceModule\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button--secondary")).click();
        Thread.sleep(3000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]")).getText(), "Maintenance");
    }

    @Test
    public void testBuzz() throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href=\"/web/index.php/buzz/viewBuzz\"]")).click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText(), "Buzz");
    }

    @Test(dataProvider = "login")
    public void testLogin(String userName, String passward) throws Exception {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passward);
        driver.findElement(By.className("orangehrm-login-button")).click();
        Thread.sleep(3000);
        //Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span")).getText(), "Dashboard");
    }

    public void testTabAdmin(String userName, String passward) throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText(), "User Management");

    }

    @Test(dataProvider = "editableName")
    public void testSearch(String userName, String passward) throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(passward);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(passward);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("Pa");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]")).click();
        Thread.sleep(1000);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
        Thread.sleep(6000);

        // Search
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(userName);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        Thread.sleep(2000);
//        //  Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText(), userName);

    }

    @Test(dataProvider = "editableName")
    public void editUser(String userName, String editable) throws Exception {
        driver.findElement(By.cssSelector(".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")).click();
        // Searching
        Thread.sleep(3000);
        try {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(userName);
        } catch (Exception e) {
            System.out.println("Nooo");
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        Thread.sleep(6000);
        // Click At Edit Button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]")).click();
        Thread.sleep(4000);

        // Delete The Last Name
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        element.clear();
        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().sendKeys(Keys.BACK_SPACE).perform();

//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).clear();
        Thread.sleep(3000);

        // Add The New Name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(editable);
        Thread.sleep(2000);

        // Click At Save Button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
        Thread.sleep(10000);

        // Searching To Check Editing
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(editable);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText(), editable);
        Thread.sleep(2000);
    }

    @Test
    public void testLogout() throws Exception {
        driver.findElement(By.className("oxd-userdropdown")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".oxd-userdropdown-link[href=\"/web/index.php/auth/logout\"]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("orangehrm-login-title")).getText(), "Login");
    }

    @Test(dataProvider = "editableName")
    public void fail(String userName) throws Exception {
        String name = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(name, userName);

        Thread.sleep(2000);

    }

    @AfterMethod
    public void failedScreenshot(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenShoot.takeShoot(driver, "D:\\Failure Shoots\\" + result.getName() + ".png");
        }
    }
}
