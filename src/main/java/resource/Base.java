package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializedDriver() throws IOException 
	{
	 prop=new Properties();
	 FileInputStream fis=new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\Resource\\data.Properties");
	
	 prop.load(fis);
	 
	 String browsername=prop.getProperty("browser");
	 String Chromekey=prop.getProperty("key");
	 String Chromevalue=prop.getProperty("value");
	 
	 if(browsername.equals("chrome"))
	 {
		 System.setProperty(Chromekey, Chromevalue);
		  driver=new ChromeDriver();
	 }
	 
	 if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Driver\\geckodriver.exe");
			 driver =new FirefoxDriver();
		}
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File source= ts.getScreenshotAs(OutputType.FILE);
	    String destinationfile=System.getProperty("user.dir") +"\\reports\\" +testCaseName +".png";
	    FileUtils.copyFile(source, new File(destinationfile));
		
		return destinationfile;
	}
	
	
}
