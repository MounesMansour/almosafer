import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver =new ChromeDriver();
    String URL = "https://global.almosafer.com/en";
	@BeforeTest
	public void mySetUp() {
		System.out.println("hey");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebElement sar= driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		sar.click();
	}
	@Test(priority = 1)
	public void checkTheLanguage() {
	String expectedLanguage="en";
	WebElement htmlTag =driver.findElement(By.tagName("html"));
	String actualLanguage =htmlTag.getAttribute("lang");
 
    Assert.assertEquals(actualLanguage, expectedLanguage, "The language attribute does not match the expected value.");
    System.out.println("Language: " + actualLanguage);
	}
	
	@Test(priority = 2)
	public void checkTheCurrencyIsSAR() {
		String expectedDefultCurrency="SAR";
		WebElement defultCurrency=driver.findElement(By.xpath("//button[@data-testid = 'Header__CurrencySelector']"));
		String actualDefultCurrency=defultCurrency.getText();
		Assert.assertEquals(actualDefultCurrency, expectedDefultCurrency);
	    System.out.println("Currency: " + actualDefultCurrency);

	}
	
	@Test(priority = 3)
	public void checkTheContactNumber() {
		String expectedContactNumber="+966554400000";
		WebElement ContactNumber=driver.findElement(By.tagName("strong"));
		String actualContactNumber=ContactNumber.getText();
		Assert.assertEquals(actualContactNumber, expectedContactNumber);
	    System.out.println("ContactNumber: " + actualContactNumber);

	}
	
	
	@Test(priority = 4)
	public void checkTheQitafLogoIsThereInFooter() {
		boolean QitafLogoIsThere =true;
		WebElement footer=driver.findElement(By.tagName("footer"));
		WebElement qitafLogo= footer.findElement(By.cssSelector(".sc-fihHvN.eYrDjb")).findElement(By.tagName("svg"));
		boolean auctualQitafLogo =qitafLogo.isDisplayed();
		Assert.assertEquals(auctualQitafLogo, QitafLogoIsThere);
        System.out.println("Qitaf logo is displayed: " + auctualQitafLogo);

	}
	
}
