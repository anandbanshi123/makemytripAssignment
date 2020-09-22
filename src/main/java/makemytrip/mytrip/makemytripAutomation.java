package makemytrip.mytrip;

import java.io.File;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import makemytrip.page.fligthList;
import makemytrip.page.home;
import makemytrip.utitlites.base;

/**
 * Hello world!
 *
 */
public class makemytripAutomation extends base
{

	home home;
	fligthList fligthList ;

	String username;
	String password;
	@AfterMethod
	public void invokeScreenshotMethod(ITestResult res)
	{
		logger.info("Executing Step - Screen shot process");
		if (ITestResult.FAILURE==res.getStatus()){
			try{
				TakesScreenshot ts=(TakesScreenshot) driver;
				File src= ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("../mytrip/resources/screenshot"+res.getName()+".png"));
			}catch(Exception e)
			{
			logger.error("Failed in take - Screen shot process");
			}
		}
		}
		@Given("^User Open the browser$")
		public void user_Open_the_browser() throws Throwable {
			logger.info("Executing Step - Search the flight");
			initialisation("HTMLUnit");
			fligthList =new fligthList();
			home= new home();
		}

		@Given("^User enter the URL of makemytrip\\.com in browser$")
		public void user_enter_the_URL_of_makemytrip_com_in_browser() throws Throwable {
			enterTheURL(); 
		}

		@When("^User selects the fligt destination from to$")
		public void user_selects_the_fligt_destination_from_to(DataTable destinationData) throws Throwable {
			logger.info("Executing Step - feature creation process");
			try {
				List<List<String>> list = destinationData.raw();

				for (int row = 1; row < list.size(); row++) {
					String from = list.get(row).get(0);
					String to= list.get(row).get(1);
					home.enterDestinationDetail(from, to);
				}
			}catch(Exception e) {

			}

		}


		@When("^Enter date for depature after (\\d+) days$")
		public void enter_date_for_depature_after_days(int arg1) throws Throwable {
			home.clickOndate();
			int weekNo=getMonthWeekno(30);
			int dayNo=getWeekdayNo(30);
			home.selectdate(weekNo, dayNo);
			
		}


		@When("^Select the passanger and class$")
		public void select_the_passanger_and_class() throws Throwable {

		}

		@When("^User click on search$")
		public void user_click_on_search() throws Throwable {
			home.clickOnsearch();
		}

		@Then("^Verify that the flight list is as per on required date\\.$")
		public void verify_that_the_flight_list_is_as_per_on_required_date() throws Throwable {
			String actual = fligthList.validateListasperdate();
			logger.info("Current date -"+getdate(0));
			logger.info("Date after 30 days -"+actual);
		}

		@When("^user select the one stop flight$")
		public void user_select_the_one_stop_flight() throws Throwable {
				fligthList.clickoneStop();
		}

		@Then("^verify that the list should be one stop flight\\.$")
		public void verify_that_the_list_should_be_one_stop_flight() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			logger.info("flight oneStop count-"+fligthList.getOnestopcount());

		}

		@Then("^Print the count one stop flight and lowestprice\\.$")
		public void print_the_count_one_stop_flight_and_lowestprice() throws Throwable {
			logger.info("Flight count is"+fligthList.getOnestopcount());
			logger.info("Flight lowest price is"+fligthList.getLowestprice());
		}

	}
