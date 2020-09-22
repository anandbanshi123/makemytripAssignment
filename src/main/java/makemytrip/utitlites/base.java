package makemytrip.utitlites;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class base {


	public static long page_load_timeout = 20;
	public static long Implicit_wait = 30;
	static String proxyHost = System.getenv("AUTOMATION_PROXY_HOST");
	static String proxyPort = System.getenv("AUTOMATION_PROXY_PORT"); 



	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger = LogManager.getRootLogger();  
	public static String URL;
	public base()
	{
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("../mytrip/resources/data/config.properties");
			prop.load(file);
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		URL=prop.getProperty("URL");
	}

    private static final boolean HEADLESS = true;

	public static void initialisation(String browserName)
	{
		String BrowserName ="chrome";
		System.out.print(BrowserName);
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "../mytrip/resources/data/chromedriver.exe");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			ChromeOptions options = new ChromeOptions();
			//options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(page_load_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Implicit_wait, TimeUnit.SECONDS);

		}
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "../ECP/lib/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(page_load_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Implicit_wait, TimeUnit.SECONDS);

		}else if (BrowserName.equalsIgnoreCase("HTMLUnit")) {
			WebDriver driver = new HtmlUnitDriver();
			driver.get("https://www.makemytrip.com");
				
		}


	}
	public static void enterTheURL() {
		driver.get(URL);
	}
	public void closeInstance() {
		driver.close();
	}
	public int getWeekdayNo(int days) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
		// date=date.30;
		int day = calendar.get(Calendar.DATE);
		System.out.println("Current Date is: " + date);
		Calendar c= Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date d=c.getTime();
		int dayNo= c.get(c.DAY_OF_WEEK);
		System.out.println(d);
		System.out.println(dayNo);
		return dayNo;
	}
	public int getMonthWeekno(int days) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
		// date=date.30;
		int day = calendar.get(Calendar.DATE);
		System.out.println("Current Date is: " + date);
		Calendar c= Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date d=c.getTime();
		int No= c.get(c.WEEK_OF_MONTH);
		System.out.println(d);
		System.out.println(No);
		return No;
	}
	public String getdate(int days) {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
		// date=date.30;
		int day = calendar.get(Calendar.DATE);
		System.out.println("Current Date is: " + date);
		Calendar c= Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date d=c.getTime();
		DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy");  
		String expected=dateFormat.format(d);
		return expected;
		}
}
