package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //Verify the text “PRODUCTS”
        String expectResult = "Products";
        String actualResult = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectResult,actualResult);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //Verify that six products are displayed on page

        List<WebElement> productSize = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));

          Assert.assertEquals("products is not displayed six",6,productSize.size());


    }
    //    @After
//    public void tearDown() {
//        closeBrowser();
//    }

}
