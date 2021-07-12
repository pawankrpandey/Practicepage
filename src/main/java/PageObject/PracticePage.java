package PageObject;



import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage {

	public WebDriver driver;
	
	

	public PracticePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//new window
	private	@FindBy(xpath="//input[@class='wikipedia-search-input']")
	WebElement newWindow;
	private	@FindBy(xpath="//input[@type='submit']")
	WebElement searchbutton;
	private	@FindBy(xpath="//a[text()='India']")
	WebElement indianidol;

	
	//Alert button
	private	@FindBy(xpath="//button[@onclick='myFunction()']")
	WebElement alertButton;
	
	//Calendar
	private	@FindBy(id="datepicker")
	WebElement date;
	
	private	@FindBy(xpath="//div[@id='ui-datepicker-div']")
	WebElement month;
	
	private	@FindBy(xpath="//span[text()='Next']")
	WebElement forward;
	
	private	@FindBy(xpath="//a[@class='ui-state-default']")
	List<WebElement> day;

	
	//SelectMenu
	private @FindBy(id="speed")
	WebElement selectMenuSpeeds;
	
	private @FindBy(id="files")
	WebElement selectMenuFiles;
	
	private @FindBy(id="number")
	WebElement selectMenuNumber;
	
	
	//Text Menu
	private @FindBy(xpath="//div[@class='widget Text']//div//div[1]")
	WebElement textMenu;
	
	private @FindBy(xpath="//div[@class='widget Text']//div//div[2]")
	WebElement textmenu;
	
	
	//Table
	
	private @FindBy(xpath="//div[@class='widget-content']//table//tbody")
	WebElement table;		
	
	//ToolTip
	private @FindBy(id="age")
	WebElement toolTip;
	
	//volunteerSingUp
	private @FindBy(id="RESULT_TextField-1")
	WebElement firstName;
	
	private @FindBy(id="RESULT_TextField-2")
	WebElement lasttName;
	
	private @FindBy(id="RESULT_TextField-3")
	WebElement phone;
	
	private @FindBy(id="RESULT_TextField-4")
	WebElement country;
	
	private @FindBy(id="RESULT_TextField-5")
	WebElement city;
	
	private @FindBy(id="RESULT_TextField-6")
	WebElement email;
	
	//radio button
	
	private @FindBy(id="RESULT_RadioButton-7_0")
	WebElement radio;
	
	//radio button
	
    private @FindBy(className="inline_grid choices")
    List<WebElement> checkbox;
	
	private @FindBy(id="RESULT_CheckBox-8_4")
	WebElement thrusday;
	
	
	//Double click
	
    private @FindBy(xpath="//button[@ondblclick='myFunction1()']")
    WebElement Doubleclick;
   
    
    //DragAndDrop
    private @FindBy(id="draggable")
    WebElement source;
    
    private @FindBy(id="droppable")
    WebElement target;
   
    //slider
    private @FindBy(xpath="//div[@id='slider']//span")
    WebElement  slider;
 
    //resize
    private @FindBy(xpath=" //div[@class='ui-resizable-handle ui-resizable-e']")
    WebElement  resize;

    //Barcode
    private @FindBy(xpath="//div[@id='HTML12']//div//img[2]")
    WebElement  barcode;
    
	
	public WebElement newWindow()
	{
	return newWindow;
	}
	
	public WebElement searchbutton()
	{
	return searchbutton;
	}
	
	public WebElement indianidol()
	{
	return indianidol;
	}
	
	public WebElement alertButton()
	{
	return alertButton;
		 
	}


	public WebElement date()
	{	
	return date;
	}

	public WebElement month()
	{	
	return month;
	}
	
	public WebElement forward()
	{	
	return forward;
	}
	
	public List<WebElement> day()
	{	
	return day;
	}
	
	public WebElement selectMenuSpeeds()
	{
	return selectMenuSpeeds;	
	}
	
	public WebElement selectMenuFiles()
	{
	return selectMenuFiles;	
	}
	
	public WebElement selectMenuNumber()
	{
	return selectMenuNumber;	
	}
	
	
	public WebElement textMenu()
	{
		return textMenu;
		
	}
	
	public WebElement textmenu()
	{
		return textmenu;	
	}
	
	public WebElement table()
	{
		return table;	
	}
	

	public WebElement toolTip()
	{	
		return toolTip;
	}

	public WebElement firstName()
	{	
		return firstName;
	}
	
	public WebElement lasttName()
	{
		return lasttName;
	}
	
	public WebElement phone()
	{
		return phone;
	}
	
	public WebElement country()
	{
		return country;
	}
	
	public WebElement city()
	{
		return city;
	}
	
	public WebElement email()
	{
		return email;
	}
	
	public WebElement radio()
	{
		return radio;
	}
	
	public List<WebElement> checkbox()
	{

		return checkbox;
	}
	
	public WebElement thrusday()
	{
		return thrusday;
	}
	
	public WebElement Doubleclick()
	{
	 return Doubleclick;
	}
	
	public WebElement source()
	{ 
	 return source; 
	}


	public WebElement target()
	{ 
	 return target; 
	}
	 
	public WebElement slider()
	{ 
	return slider; 
	}
		
	public WebElement resize()
	{ 
	return resize; 
	}

	public WebElement barcode()
	{ 
	return barcode; 
	}
	
	
	
	
	
}
