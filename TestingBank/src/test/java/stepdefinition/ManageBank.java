package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageBank {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	String status1 ="result found";
	String status2 ="not found";
	@Given("user is on manager page")
	public void user_is_on_manager_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
	}
	
	//Verify manage page
	@Given("verify manage page")
	public void verify_manage_page() throws Throwable {
		
		String manageCusPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(manageCusPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		
		String manageCusPageTitle = driver.getTitle();
		Assert.assertEquals(manageCusPageTitle, "XYZ Bank");
		Thread.sleep(2*1000);
	}

	//Add new customer
	@When("user click on Add Customer button")
	public void user_click_on_add_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		Thread.sleep(2*1000);
	}

	@When("user enter <firstname> and <lastname> and <postcode>")
	public void user_enter_firstname_and_lastname_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Sen");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Hương");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("21042001");
		Thread.sleep(1000);
	}
	
	@When("user enter <firstname> and <postcode>")
	public void user_enter_lastname_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Sen");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("21042001");
		Thread.sleep(1000);
	}
	
	@And("click Add on Customer button")
	public void click_add_on_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2*1000);
	}
	
	@And("click ok of alert box")
	public void click_ok_of_alert_box() throws Throwable {
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	//Verify data when user add a new customer successful
	
	@And("verify data")
	public void verify_data() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hương");
		int verifyDataAdd = driver.findElements(By.xpath("//td[contains(text(),'Hương')]")).size();
		if (verifyDataAdd > 1) {
			System.out.println(verifyDataAdd - 1 + " " + status1);
		}else {
			System.out.println(status2);
		}
		Thread.sleep(2*1000);
	}
	
	
	//Open Account
	
	@When("user click on Open Account button")
	public void user_click_on_open_account_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("select <account> and <currency>")
	public void select_account_and_currency() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Neville Longbottom')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("currency")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Dollar')]")).click();
		Thread.sleep(1000);
	}

	@When("select <account>")
	public void select_account() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Neville Longbottom')]")).click();
		Thread.sleep(1000);
	}

	@And("click on process button")
	public void click_on_process_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		Thread.sleep(2*1000);
		
	}
	
	//Search Customer
	
	@When("user click on Customer button")
	public void user_click_on_customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("user search customer exist")
	public void user_search_customer_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Neville");
		Thread.sleep(2*1000);
	}

	@When("user search customer does not exist")
	public void user_search_customer_does_not_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("MinhThuy");
		Thread.sleep(2*1000);
	}
	
	//Verify search customer with name
	
	@When("verify search customer")
	public void verify_search_customer() {
		int verifyDataSearch = driver.findElements(By.xpath("//td[contains(text(),'Neville')]")).size();
		if (verifyDataSearch > 0) {
			System.out.println(verifyDataSearch + "" + status1);
		}else {
			System.out.println(status2);
		}
	}
	
	@Then("message is display")
	public void message_is_display() {
		driver.quit();
	    System.out.println("Successfully excution");
	}

}
