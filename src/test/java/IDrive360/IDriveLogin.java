package IDrive360;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class IDriveLogin {

    @Test
    public void loginvalid() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.idrive360.com/enterprise/login");

        try {
            Thread.sleep(8000);
        }
        catch(InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Enter email ID
        WebElement uname = driver.findElement(By.id("username"));
        uname.sendKeys("augtest_040823@idrive.com");

        //Enter Password
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("123456");

        //Click Signin button
        WebElement Signbtn = driver.findElement(By.id("frm-btn"));
        Signbtn.click();

        //List<WebElement> buttons = driver.findElements(By.tagName("button"));
        //buttons.get(0).click();

        try {
            Thread.sleep(8000);
        }
        catch(InterruptedException e) {
            throw new RuntimeException(e);
        }

      // WebElement message = driver.findElement(By.xpath("//*[@id=\'upgrade]/span"));

        //assertEquals(message.getText(),"Your free trial has expired");
        assertEquals(driver.findElement(By.className("id-card-title")).getText(), "Your free trial has expired");
        assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/account?upgradenow=true");

         Thread.sleep(8000);
         driver.quit();

    }

}
