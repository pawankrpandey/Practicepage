package TDD.Practicepage;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import PageObject.PracticePage;
import resource.Base;

public class Navigation extends Base {
	
	public WebDriver driver;
	public PracticePage p;
	public Actions	a;
	public WebElement dropdown;
	public Select s;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializedDriver();
		
		driver.get(prop.getProperty("url"));
		p=new PracticePage(driver); 
	}
	
	
	//practice git
	
	@Test(priority=1,groups={"smoke","sanity"})
	public void newWindow() 
	{
		
    
	p.newWindow().sendKeys("india");
	p.searchbutton().click();
	p.indianidol().click();
    System.out.println(p.indianidol().getText());
    
    Set<String> window=driver.getWindowHandles();
    Iterator<String>it=  window.iterator();
    String parent=it.next();
    String child=it.next();
    driver.switchTo().window(child);
    driver.close();
    driver.switchTo().window(parent);
		System.out.println(p.newWindow().getText());
			
	
	}
	
	
	@Test(priority=2,groups={"smoke","sanity"})
	public void alertWindow()
	{
		
		p.alertButton().click();
		driver.switchTo().alert().accept();
		
	}
	
	
	@Test(priority=3,groups={"smoke","sanity"})
	public void datepicker()
	{
		p.date().click();
		try {
		while(!p.month().getText().contains("December"))
		{
		p.forward().click();
		}
		    
		}    
		
		catch(Exception e) {}
			
		List<WebElement> days= p.day();
		
		int count=  days.size();
		System.out.println(count);
		for(int i=0;i<count;i++) 
		{
		String text=p.day().get(i).getText();
				
		if(text.equalsIgnoreCase("20")) 
		{
		p.day().get(i).click();
		System.out.println(text);
		break;
					
		}
				
		}
	
	
	}
//,dependsOnMethods= {"datepicker"}
	@Test(priority=4,groups={"smoke","sanity"})
	public void selectMenuSpeeds()
	{ 
		dropdown=p.selectMenuSpeeds();
		dropdown.click();
		
		s=new Select(dropdown);
		s.selectByIndex(4);	
		System.out.println(s.getFirstSelectedOption().getText());
		
	}
	
	
	@Test(priority=5,groups={"smoke"})
	public void selectMenuFiles()
	{  
	    dropdown= p.selectMenuFiles();
	    dropdown.click();
		s=new Select(dropdown);
		s.selectByValue("3");
		System.out.println(s.getFirstSelectedOption().getText());
	
	}

	
	@Test(priority=6,groups= {"smoke"})
	public void selectMenuNumber()
	{  
		dropdown= p.selectMenuNumber();
	    dropdown.click();
		s=new Select(dropdown);
		s.selectByVisibleText("3");
		System.out.println(s.getFirstSelectedOption().getText());
	
		
	}
	

	@Test(priority=7,groups= {"smoke"})
	public void textMenu()
	{
		System.out.println(p.textMenu().getText().split("-")[1].trim());
		System.out.println(p.textmenu().getText().split(" ")[1].trim());
		
	}

	
	@Test(priority=8,groups= {"smoke"})
	public void table()
	{
		System.out.println(p.table().findElements(By.tagName("tr")).size());
		System.out.println(p.table().findElements(By.tagName("th")).size());
		List<WebElement> row=p.table().findElements(By.tagName("tr")).get(5).findElements(By.tagName("td"));
		System.out.println(row.get(0).getText());
		System.out.println(row.get(1).getText());
		System.out.println(row.get(2).getText());
		System.out.println(row.get(3).getText());
	
		System.out.println(p.table().getText());
	
	
	}
	

	@Test(priority=9,groups= {"smoke"})
	public void toolTip() 
	{
		p.toolTip();
		 a=new Actions(driver);
		 a.moveToElement(p.toolTip()).build().perform();	
		
		System.out.println(p.toolTip().getText());
		System.out.println(p.toolTip().getAttribute("id"));
		System.out.println(p.toolTip().getAttribute("title"));
	    System.out.println(p.toolTip().getTagName());
	    
	    
	}
	
	
	//@Test(priority=10,groups= {"smoke"})
	//@Parameters({"Mr","title"})
//	public void firstName( @Optional String Mr,@Optional String title)
//	{
//		System.out.println("name->" + Mr);
//		System.out.println("surname->" +title);
//		System.out.println("name->" + Mr+" "+"surname->"+title);
//		System.out.println( Mr+" "+title);
//	//p.firstName().sendKeys("pawan");
//	
//	}

	
	@Test(priority=11,groups= {"smoke"},dataProvider="pawan")
	public void lasttName(String username ,int password ,String status,String s)
	{
		System.out.println(username);
		System.out.println(password);
		System.out.println(status);
		System.out.println(s);
	//p.lasttName().sendKeys("pandey");
	}

	
	@Test(priority=12,groups= {"smoke"})
	public void phone() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\pawan\\Excledrive\\demo.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		//identify the sheet by sheet name
		int sheet=workbook.getNumberOfSheets();
		for(int i=0;i<sheet;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) 
	    {
				
		XSSFSheet sheets=workbook.getSheetAt(i);
		
		//Identify the test case coloum by scanning the entire 1st row
		
		Iterator<Row> rows =sheets.iterator();
		Row firstrow=rows.next();
		
		Iterator<Cell> cel= firstrow.cellIterator();
		
		int k=0;
		int coloum=0;
		while(cel.hasNext())
		{
		Cell value=	cel.next();
		if(value.getStringCellValue().equalsIgnoreCase("Data1"))
		{
			coloum=k;
		}
		k++;
		}
		System.out.println(coloum);	
		
		while(rows.hasNext())	
		{
		Row r=	rows.next();
		if(r.getCell(coloum).getStringCellValue().equalsIgnoreCase("amazon"))
		{
			Iterator<Cell> c=r.cellIterator();
			while(c.hasNext())
			{
				System.out.println(c.next().getStringCellValue());
			}
		}
		}
	    }	
		}
	
	
	}

	
	@Test(priority=13,groups= {"smoke"})
	public void country() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\pawan\\Excledrive\\demo2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet s = workbook.getSheetAt(0);
		
		Row rows = s.getRow(0);
		Cell cell = rows.createCell(4);
		cell.setCellValue("Age");
	
		int lastRow = s.getLastRowNum();
		for(int i=1; i<=lastRow; i++)
		{
		Row row = s.getRow(i);
		Cell cell1 = row.createCell(4);
		cell1.setCellValue("32");
		//cell1.removeCellComment();
		}
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\pawan\\Excledrive\\demo2.xlsx");
		workbook.write(fos);
		fos.close();
		}
	
	
	@Test(priority=14,groups= {"regration"})
	public void city()
	{
	//p.city().sendKeys("jsr");
	
	}

	
	@Test(priority=15,groups= {"regration"})
	public void email()
	{
	//p.email().sendKeys("pawan@123");
	
	}

	
	@Test(priority=16,groups= {"regration"})
	public void radio()
	{
	//p.radio().click();
	
	}

	
	@Test(priority=17,groups= {"regration"})
	public void checkbox()
	{
//		int count=p.checkbox().size();
//		System.out.println(count);
//		
//		for(int i=0; i<count; i++)
//		{
//			String counttotal=p.checkbox().get(i).getText();
//			System.out.println(counttotal);
//			break;
//		}
		
	//System.out.println(p.checkbox());
	
	}

	
	@Test (priority=18,groups= {"regration"})
	public void thrusday()
	{
	//p.thrusday().click();
	}

	
	@Test(priority=19,groups= {"sanity"})
	public void Doubleclick() 
	{
		
		 a=new Actions(driver);
		 a.doubleClick(p.Doubleclick()).build().perform();
		 
		 
	}

	
	@Test(priority=20,groups= {"sanity"})
	public void dragAndDrop() 
	{
		
	a=new Actions(driver);
	a.dragAndDrop(p.source(), p.target()).build().perform();
	System.out.println(p.source().getAttribute("id"));
	System.out.println(p.target().getAttribute("id"));
	

	}

	
	@Test(priority=21,groups= {"sanity"})
	public void sliders()
	{
		a.dragAndDropBy(p.slider(), 90, 0).build().perform();
		
	}

	
	@Test(priority=22,groups= {"sanity"})
	public void resize()
	{  
		a.dragAndDropBy(p.resize(), 20, 50).build().perform();
		
	}

	
	@Test(priority=23,groups= {"sanity"})
	public void barcodes() throws IOException, NotFoundException
	{
			
		p.barcode().click();
		String value=p.barcode().getAttribute("src");
		URL url=new URL(value);
		BufferedImage img=ImageIO.read(url);
		LuminanceSource l=new BufferedImageLuminanceSource(img);
	    BinaryBitmap b=new BinaryBitmap(new HybridBinarizer(l));
	    Result r=new MultiFormatReader().decode(b);
	    System.out.println(r.getText());
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	@DataProvider(name="pawan")
	public Object[][] getData()
	{  //0 row
		Object[][] data=new Object[4][4];
		data[0][0]="pawan@gmail.com";
		data[0][1]=12345;
		data[0][2]="hey";
		data[0][3]="world";
		//1 row
		data[1][0]="pandey@gmail.com";
		data[1][1]=456789;
		data[1][2]="how";
		data[1][3]="world";
		//2
		data[2][0]="hare@gmail.com";
		data[2][1]=123;
		data[2][2]="hi";
		data[2][3]="world";
		//3
		data[3][0]="krishna@gmail.com";
		data[3][1]=456;
		data[3][2]="hello";
		data[3][3]="world";
		return data;
	}
	
	
	
	
}