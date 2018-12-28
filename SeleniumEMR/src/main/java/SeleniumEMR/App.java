package SeleniumEMR;

/**
 * Hello world!
 *
 */
 
 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	protected String baseURL = "http://10.100.21.57:8096/mobiledoc/jsp/webemr/login/newLogin.jsp#/mobiledoc/jsp/webemr/scheduling/resourceSchedule.jsp";
	private String driverPath = "H:\\selenium-java-3.14.0\\chromedriver.exe";
	public WebDriver driver;

	@Test(priority = 1)
	public void launchBrowser() {
		System.out.println("launching 11e EMR Login");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@Test(priority = 2)
	public void LoginToEMR() throws InterruptedException {

		driver.findElement(By.id("doctorID")).sendKeys("sam");
		driver.findElement(By.id("nextStep")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("passwordField")).sendKeys("password$1");
		driver.findElement(By.id("Login")).click();
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick='ignorePluginModal()']")));
		driver.findElement(By.xpath("//*[@onclick='ignorePluginModal()']")).click();

		Thread.sleep(10000);

		driver.findElement(By.cssSelector("#providerLicense > div > div > div.modal-footer.grey-bg > button")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='alert']/div/div/div[2]/div[1]/center/table/tbody/tr/td[2]/button"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='facilityListBtn1']")).click();
		Thread.sleep(1000);

	}

	@Test(priority = 3)
	public void SearchPT() throws InterruptedException {

		driver.findElement(By.id("jellybean-panelLink65")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Thread.sleep(2000);
		driver.findElement(By.id("searchText")).sendKeys("John,Acti14");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@ng-click='launchPatientHub(patient)']")).click();

	}

	@Test(priority = 4)
	public void goToProgressNotes() {

		driver.findElement(By.id("patient-hubBtn9")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test(enabled = false)
	public void addMeds() throws InterruptedException {

		driver.findElement(By.linkText("Current Medication:")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-bb-handler='Yes']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@data-bb-handler='Yes']")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("#searchBoxMQSD_TopClass")).click();
		driver.findElement(By.xpath("//*[@ng-model='searchText.name']")).sendKeys("lipitor");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("QuickOrderTemplateLink1ngR0")).click();
	/*	Thread.sleep(2000);
		driver.findElement(By.id("QuickOrderTemplateBtn1")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@ng-click='saveData(true)']")).click();*/
		driver.findElement(By.cssSelector("#pnModalBtn1")).click();
		
	}

	@Test(priority = 5)
	public void addLab() throws InterruptedException {
	//	WebDriverWait wait = new WebDriverWait(driver,20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//WebElement labButon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='topPanelLink16']")));
		driver.findElement(By.xpath("//*[@id='topPanelLink16']")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("LabDIProcHistoryDetailBtn2")).click();
		Thread.sleep(6000);

		driver.findElement(By.id("lab-lookupIpt1")).click();

		driver.findElement(By.id("lab-lookupIpt1")).sendKeys("lipid panel");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#lab-lookupUl1")).click();
		// driver.findElement(By.linkText("OGP2p")).click();
	/*	driver.findElement(By.cssSelector("[ng-disabled='!bEnableInHouseChkBox']")).click();
		driver.findElement(By.cssSelector(
				"body > div.bootbox.modal.fade.bluetheme.medium-width.in > div > div > div.modal-footer > button"))
				.click();*/
		WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#LabReportLink4")));
		driver.findElement(By.cssSelector("#LabReportLink4")).click();
		driver.findElement(By.xpath("//*[@id='ResultsTab']/div/div[6]/div/div[1]/div[2]/div/div/div/div/div[4]/div")).click();
		WebElement currentElement = driver.switchTo().activeElement();
		currentElement.sendKeys("52");
		
	
			currentElement.sendKeys(Keys.TAB);
			currentElement = driver.switchTo().activeElement();

			currentElement.sendKeys("110");

		driver.findElement(By.id("LabReportIpt19")).click();
		
		driver.findElement(By.id("LabReportIpt9")).click();

		driver.findElement(By.id("LabReportBtn36")).click();


	}

}
