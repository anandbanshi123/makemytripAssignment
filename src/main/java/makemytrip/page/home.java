package makemytrip.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import makemytrip.utitlites.base;


public class home extends base {
	@FindBy(xpath ="/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
	WebElement destinationFrom;

	@FindBy(xpath ="/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/label/input")
	WebElement destinationTo;

	@FindBy(xpath ="/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[3]/label/p[1]")
	WebElement destinationDate;

	@FindBy(xpath ="/html/body/div/div/div[2]/div/div/div[2]/p/a")
	WebElement Search;

	@FindBy(xpath ="/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
	WebElement from;

	public home() {
		PageFactory.initElements(driver, this);
	}


	public void enterDestinationDetail(String from,String to) {
		Actions act =  new Actions(driver);
		act.moveToElement(destinationFrom).click().perform();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys(from);
		Select select=new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div")));
		select.selectByVisibleText(from);
		destinationTo.click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys(to);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div/div[1]/ul/li/div/div[1]")).click();
		
		//Select selectt=new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div")));
		//selectt.selectByVisibleText(to);

	}

	public void clickOnsearch() {
		Actions act =  new Actions(driver);
		act.moveToElement(Search).click().perform();
		
	}
	public void clickOndate() {
		Actions act =  new Actions(driver);
		act.moveToElement(destinationDate).click().perform();
		

	}


	public void selectdate(int i, int j) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[3]/div")));
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div["+i+"]/div["+j+"]"))).click();
	}
}
