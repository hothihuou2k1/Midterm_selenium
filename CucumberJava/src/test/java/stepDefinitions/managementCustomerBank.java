package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class managementCustomerBank {
WebDriver driver = null;
	
	@Given("user move to the management customer")

	public void user_is_on_manager_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
	}
	
	@Given("verify to the management page")
	public void verify_manage_page() throws Throwable {
		String manageCusPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(manageCusPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		String manageCusPageTitle = driver.getTitle();
		Assert.assertEquals(manageCusPageTitle, "XYZ Bank");
		Thread.sleep(2*1000);
	}

	//Add new customer
	@When("the user click on add customer button")
	public void user_click_on_add_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		Thread.sleep(2*1000);
	}

	@When("user enter <firstName> and <lastName> and <code>")
	public void user_enter_firstname_and_lastname_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Huou");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Thi");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("huou123");
		Thread.sleep(1000);
	}
	
	@When("user enter <lastName> and <code>")
	public void user_enter_lastname_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Huou");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("huouthi123");
		Thread.sleep(1000);
	}
	
	@And("click add on customer button")
	public void click_add_on_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2*1000);
	}
	
	@And("user click to OK of the alert box")
	public void click_ok_of_alert_box() throws Throwable {
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	@And("verify to data")
	public void verify_data() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Huou");
		int verifyDataAdd = driver.findElements(By.xpath("//td[contains(text(),'Thi')]")).size();
		if (verifyDataAdd > 1) {
			System.out.println(verifyDataAdd - 1 + " " + "result found");
		}else {
			System.out.println("No result");
		}
		Thread.sleep(2*1000);
	}
	
	
	@When("user click on open an account button")
	public void user_click_on_open_account_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("user to select <account> and <currency>")
	public void select_account_and_currency() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Hermoine Granger')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("currency")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Dollar')]")).click();
		Thread.sleep(1000);
	}

	@When("user to select <account>")
	public void select_account() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Hermoine Granger')]")).click();
		Thread.sleep(1000);
	}

	@And("user click on the process button")
	public void click_on_process_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		Thread.sleep(2*1000);
		
	}
	

	@When("user click on Customer button")
	public void user_click_on_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("user to search customer is exist")
	public void user_search_customer_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hermoine");
		Thread.sleep(2*1000);
	}

	@When("user to search customer is not exist")
	public void user_search_customer_does_not_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Huou");
		Thread.sleep(2*1000);
	}
	
	@When("verify to search customer")
	public void verify_search_customer() {
		int verifyDataSearch = driver.findElements(By.xpath("//td[contains(text(),'Hermoine')]")).size();
		if (verifyDataSearch > 0) {
			System.out.println(verifyDataSearch + " " + "result found");
		}else {
			System.out.println("No result");
		}
	}
	@Then("display the message")
	public void message_is_display() {
		driver.quit();
	    System.out.println("Successfully processed");
	}

}
