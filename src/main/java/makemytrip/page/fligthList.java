package makemytrip.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import makemytrip.utitlites.base;


public class fligthList extends base {


	@FindBy(xpath ="/html/body/div[1]/div/div[2]/div[3]/div/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div")
	WebElement shiptoAddress;
	@FindBy(xpath="//*[@id=\"MenuContent\"]/a[3]")
	WebElement myAccountpage;
	@FindBy(xpath="//*[@id=\"Content\"]/ul/li")
	WebElement confromationMesage;

	public fligthList() {
		PageFactory.initElements(driver, this);
	}


	public void clickoneStop() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[3]/div/div[1]/div/span[3]/label/span/span")).click();
	}

	public String getOnestopcount() {
		return driver.findElement(By.xpath("//*[@id=\"section--wrapper\"]/div[1]/div[4]/div/div[1]/div/span[3]/label/div/div/p[1]")).getText();
	}


	public String validateListasperdate() {
		return driver.findElement(By.xpath("//*[@class=\"item blue_active\"]/a/p[1]")).getText();
		
	}
	public String getLowestprice() {
		return driver.findElement(By.xpath("//*[@id=\"section--wrapper\"]/div[1]/div[4]/div/div[1]/div/span[3]/label/div/div/p[2]")).getText();
	}
	public void selectTheonestoplist() {
		WebElement onestoplist=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[1]/div[3]/div/div[1]/div/span[2]/label/span"));
		onestoplist.click();
	}

	public int flightcount(String name) {
		List<WebElement> flightcount=driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[3]/div/div[2]/div[3]/div/div/div[1]/div[1]/div/div/div"));
		return flightcount.size();
	}

	
}
