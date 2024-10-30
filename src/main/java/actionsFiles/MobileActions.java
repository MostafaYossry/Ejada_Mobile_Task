package actionsFiles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class MobileActions {

// declare the xpaths
    private AndroidDriver driver;
    private String Username_Xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]";
    private String Password_Xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]";
    private String Login_Xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]";
    private String Items_Xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])";

// open the application on the real device
    public void Setup() throws MalformedURLException {
    
// Required capabilities
    	DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:platformVersion", "14"); //my android version, you need to change it based on the device
        cap.setCapability("appium:deviceName", "RKY-LX2"); //my real device, you need to change it based on the device
        cap.setCapability("appium:udid", "A6NY9X3609G03187"); //my real device, you need to change it based on the device
        cap.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appium:appActivity", "MainActivity");

// Create AndroidDriver instance
        driver = new AndroidDriver(new URL ("http://0.0.0.0:4723/wd/hub"), cap); // based on the opened session on "Appium Server GUI"
        }


    public void OpenApp() throws MalformedURLException, InterruptedException {
    	Setup();
    	Thread.sleep(5000);
    }

	public void AddUsername(String username) {
// Find the username field and enter the username
		WebElement UserNameFeild =  driver.findElement(By.xpath(Username_Xpath));
		UserNameFeild.sendKeys(username);
		}

	public void AddPassword(String password) {
// Find the password field and enter the password
		WebElement PasswordFeild =  driver.findElement(By.xpath(Password_Xpath));
		PasswordFeild.sendKeys(password);
	}

	public void ClickLogin() {
// Find the Login button and click
		WebElement LoginButton =  driver.findElement(By.xpath(Login_Xpath));
		LoginButton.click();
	}

	public void CheckItems() {
// Find the Items to buy
		List<WebElement> Items =  driver.findElements(By.xpath(Items_Xpath));
		Assert.assertNotNull(Items);
	}
	
	public void CheckNOItems() {
// Find there is no Items to buy
		List<WebElement> Items =  driver.findElements(By.xpath(Items_Xpath));
		Assert.assertTrue(Items.isEmpty());
	}
}
