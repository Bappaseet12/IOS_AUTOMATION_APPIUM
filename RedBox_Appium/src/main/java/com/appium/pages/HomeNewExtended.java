package com.appium.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.model.ExtLogger;
public class HomeNewExtended {
	
	private ExtLogger log = new ExtLogger(HomeNewExtended.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;
	LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public HomeNewExtended(IOSDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 40);
	}
	
	/*Element Present in Home screen and Splash Screen*/	
	@iOSFindBy(name="logo_large")
	public WebElement splashLogo;
	
	@iOSFindBy(name="In progress")
	public WebElement inProgress;
	
	
	/*Tabs in Home screen*/
	@iOSFindBy(accessibility="MORE")
	public WebElement moreTab;
	
	@iOSFindBy(name="BROWSE")
	public WebElement browseTab;
	
	@iOSFindBy(name="UPCOMING")
	public WebElement upcomingTab;
	
	@iOSFindBy(name="MY REDBOX")
	public WebElement myRedboxTab;
	
	@iOSFindBy(name="NEW")
	public WebElement newTab;
	
	/*New Release Tab*/
	@iOSFindBy(name="MOVIES")
	public WebElement moviesTab;
	
	@iOSFindBy(name="TV")
	public WebElement tvTab;
	
	@iOSFindBy(name="GAMES")
	public WebElement gamesTab;
	
	@iOSFindBy(name="Manage Location")
	public WebElement manageLocation;
	
	@iOSFindBy(name="redbox_logo_nav")
	public WebElement searchIcon;
	
	@iOSFindBy(name="My Bag")
	public WebElement my_Bag;
	
	@iOSFindBy(name="MOVIES")
	public WebElement movies;
	
	@iOSFindBy(name="TV")
	public WebElement tv;
	
	@iOSFindBy(name="GAMES")
	public WebElement games;
	
	@iOSFindBy(name="redbox")
	public WebElement redboxTitle;
	
	@iOSFindBy(name="Manage Location")
	public WebElement locationIcon;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleReelCell'])[1]/XCUIElementTypeCollectionView")
	private List<WebElement> listofmovies;
	
	@iOSFindBy(name="New at the Box")
	private WebElement newAtBoxTitleReel;
	
	@iOSFindBy(name="New On Demand")
	private WebElement newOnDemandReel;
	
	@iOSFindBy(name="TitleReelBrowseButton")
	private WebElement NewAtBoxTitleBrowseAll;
	
	@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='TitleReelBrowseButton'])[2]")
	private WebElement newOnDemandBrowseAll;
	
	@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='TitleReelBrowseButton'])[1]")
	private WebElement newPS4Reel;
	
	@iOSFindBy(xpath="(//XCUIElementTypeStaticText[@name='TitleReelNameLabel'])[2]")
	private WebElement newXBOXONEReel;
	
	@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='TitleReelBrowseButton'])[2]")
	private WebElement newXBOX360Reel;
	
	@iOSFindBy(xpath="(//XCUIElementTypeStaticText[@name='TitleReelNameLabel'])[3]")
	private WebElement newPS4BrowseAll;
	
	@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='TitleReelBrowseButton'])[3]")
	private WebElement newXBOXONEBrowseAll;
	
	@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='TitleReelBrowseButton'])[2]")
	private WebElement newXBOX360BrowseAll;	
	
	@iOSFindBy(name="TitleReelBrowseButton")
	private WebElement newTVBrowseAll;
	
	@iOSFindBy(name="TitleReelNameLabel")
	private WebElement newTVReels;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleReelCell'])[1]/XCUIElementTypeCollectionView")
	WebElement sliderOne;
	
	
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleReelCell'])[2]/XCUIElementTypeCollectionView")
	WebElement sliderTwo;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleReelCell'])[1]/XCUIElementTypeCollectionView")
	WebElement gamesSlider1;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleReelCell'])[2]/XCUIElementTypeCollectionView")
	WebElement gamesSlider2;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleReelCell'])[3]/XCUIElementTypeCollectionView")
	WebElement gamesSlider3;
	                 
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")
	WebElement titleOne;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[2]")
	WebElement titleTwo;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[3]")
	WebElement titleThree;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[4]")
	WebElement titleFour;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[5]")
	WebElement titleFive;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[6]")
	WebElement titleSix;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[7]")
	WebElement titleSeven;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[8]")
	WebElement titleEight;
	
	@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[9]")
	WebElement titleNine;
	

	
//	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name="Redbox"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypePageIndicator")
	
	/*Display of Elements*/	
	public boolean splashLogo() throws InterruptedException
	{		
		wait.until(ExpectedConditions.visibilityOf(splashLogo));
		log.stepLog("Splash screen Dispalyed");;
		return splashLogo.isDisplayed();			
	}

	public boolean inProgress()	
	{
		wait.until(ExpectedConditions.visibilityOf(inProgress));
		log.stepLog("In Progress screen Dispalyed");;
		return inProgress.isDisplayed();		
	}
	public boolean moreTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(moreTab));
		log.stepLog("More Tab is Displayed");;
		return moreTab.isDisplayed();	
	}
	public boolean browseTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(browseTab));
		log.stepLog("Browse Tab is Displayed");;
		return browseTab.isDisplayed();	
	}
	public boolean myRedboxTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(myRedboxTab));
		log.stepLog("My Redbox Tab is Displayed");;
		return myRedboxTab.isDisplayed();	
	}
	public boolean upcomingTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(upcomingTab));
		log.stepLog("Upcoming Tab is Displayed");;
		return upcomingTab.isDisplayed();	
	}
	public boolean newTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(newTab));
		log.stepLog("New Tab is Displayed");;
		return newTab.isDisplayed();	
	}
	public boolean moviesTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(moviesTab));
		log.stepLog("Movies Tab is Displayed");;
		return moviesTab.isDisplayed();	
	}
	public boolean tvTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(tvTab));
		log.stepLog("TV Tab is Displayed");;
		return tvTab.isDisplayed();	
	}
	public boolean redboxTitlepresent()
	{
		wait.until(ExpectedConditions.visibilityOf(redboxTitle));
		log.stepLog("Redbox Title is Displayed");;
		return redboxTitle.isDisplayed();	
	}
	public boolean locationIcon()
	{
		wait.until(ExpectedConditions.visibilityOf(locationIcon));
		log.stepLog("location Icon is Displayed");;
		return locationIcon.isDisplayed();	
	}
	
	public boolean gamesTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(gamesTab));
		log.stepLog("Games Tab is Displayed");;
		return gamesTab.isDisplayed();	
	}
	
	public boolean searchIconDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(searchIcon));
		log.stepLog("Search Icon is Displayed");;
		return searchIcon.isDisplayed();	
	}
	
	public boolean myBagIconDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(my_Bag));
		log.stepLog("My Bag Icon Displayed");;
		return my_Bag.isDisplayed();	
	}
	
	public boolean isNewAtBoxReelDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(newAtBoxTitleReel));
		log.stepLog("New At Box Reel Displayed");;
		return newAtBoxTitleReel.isDisplayed();	
	}
	public boolean isNewTvReelsDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(newTVReels));
		log.stepLog("New TV Reel is Displayed");;
		return newTVReels.isDisplayed();	
	}
	public boolean isNewTvBrowseAllDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(newTVBrowseAll));
		log.stepLog("New TV Browse All is Displayed");;
		return newTVBrowseAll.isDisplayed();	
	}
	public boolean isNewOnDemandDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(newOnDemandReel));
		log.stepLog("New On Demand Displayed");;
		return newOnDemandReel.isDisplayed();	
	}
	
	public boolean isNewAtTheBoxBrowseAllDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(NewAtBoxTitleBrowseAll));
		log.stepLog("New At the Box Browse All Displayed");;
		return NewAtBoxTitleBrowseAll.isDisplayed();	
	}
	
	public boolean isNewOnDemandBrowseAllDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(newOnDemandBrowseAll));
		log.stepLog("New On Demand Browse All Displayed");;
		return newOnDemandBrowseAll.isDisplayed();	
	}
	public boolean isNewPS4Reel()
	{
		wait.until(ExpectedConditions.visibilityOf(newPS4Reel));
		log.stepLog("New PS4 Inside Games Tab Displayed");;
		return newPS4Reel.isDisplayed();	
	}
	public boolean isNewPS4BrowseAll()
	{
		wait.until(ExpectedConditions.visibilityOf(newPS4BrowseAll));
		log.stepLog("New PS4 Browse All Inside Games Tab Displayed");;
		return newPS4BrowseAll.isDisplayed();	
	}
	
	public boolean isNewPS4XBOXOneReel()
	{
		wait.until(ExpectedConditions.visibilityOf(newXBOXONEReel));
		log.stepLog("New XBOX ONE Inside Games Tab Displayed");;
		return newXBOXONEReel.isDisplayed();	
	}
	public boolean isNewPS4XBOXOneBrowseAll()
	{
		wait.until(ExpectedConditions.visibilityOf(newXBOXONEBrowseAll));
		log.stepLog("New XBOX ONE Browse All Inside Games Tab Displayed");;
		return newXBOXONEBrowseAll.isDisplayed();	
	}
	
	public boolean isNewXBOX360Reel()
	{
		wait.until(ExpectedConditions.visibilityOf(newXBOX360Reel));
		log.stepLog("New XBOX 360 Reel Inside Games Tab Displayed");;
		return newXBOX360Reel.isDisplayed();	
	}
	
	public boolean isNewXBOX360BrowseAll()
	{
		wait.until(ExpectedConditions.visibilityOf(newXBOX360BrowseAll));
		log.stepLog("New XBOX 360 Browse All Inside Games Tab Displayed");;
		return newXBOX360BrowseAll.isDisplayed();	
	}
	
	public boolean countTitle()
	{
		
	return hashSet.isEmpty();
	
	}
	
	public boolean countReel()
	{
		
	return hashSet.size()==20;
	
	}
		
	/*Methods for Elements*/
	
	public void moreTab()
	{
		wait.until(ExpectedConditions.visibilityOf(moreTab));
		log.stepLog("Displayed");
		moreTab.click();
	}
	public void browseTab()
	{
		wait.until(ExpectedConditions.visibilityOf(browseTab));
		browseTab.click();
	}
	public void myRedboxTab()
	{
		wait.until(ExpectedConditions.visibilityOf(myRedboxTab));
		myRedboxTab.click();
	}
	public void upcomingTab()
	{
		wait.until(ExpectedConditions.visibilityOf(upcomingTab));
		upcomingTab.click();
	}
	public void newTab()
	{
		wait.until(ExpectedConditions.visibilityOf(newTab));
		newTab.click();
	}
	public void moviesTab()
	{
		wait.until(ExpectedConditions.visibilityOf(moviesTab));
		moviesTab.click();
	}
	public void tvTab()
	{
		wait.until(ExpectedConditions.visibilityOf(tvTab));
		tvTab.click();
	}
	public void gamesTab()
	{
		wait.until(ExpectedConditions.visibilityOf(gamesTab));
		gamesTab.click();
	}
	public void manageLocation()
	{
		wait.until(ExpectedConditions.visibilityOf(manageLocation));
		manageLocation.click();
	}
	public void getMoviesName(){
		for(int i=0;i<listofmovies.size();i++)
			System.out.println(listofmovies.get(i).getText());
	}
	/*Method for Getting attribute*/
	public String getAttribute(String attribute, WebElement element)
	{
		return element.getAttribute(attribute);
		
	}
	
	/*Method for scroll for New at the box*/
	public void scrollToUp()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");			
		scrollObject.put("element", ((RemoteWebElement) sliderOne).getId());
		js.executeScript("mobile: scroll", scrollObject);
		js.executeScript("mobile: scroll", scrollObject);
		
		}
	
	
	public void slideGamesNewPS4first(){
		scrollToUpGamesTab(gamesSlider1);
	}
	
	public void slideGamesNewXBOXONESecond(){
		scrollToUpGamesTab(gamesSlider2);
	}
	
	public void slideGamesNewXBOXONEThird(){
		scrollToUpGamesTab(gamesSlider3);
	}
	
	public void scrollToUpGamesTab(WebElement slider)
	{
		JavascriptExecutor jsGames = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObjectGames = new HashMap<String, String>();
		scrollObjectGames.put("direction", "down");			
		scrollObjectGames.put("element", ((RemoteWebElement) slider).getId());
		jsGames.executeScript("mobile: scroll", scrollObjectGames);
		jsGames.executeScript("mobile: scroll", scrollObjectGames);
		
		}
	public void scrollToRightNewAtTheBoxReel(){
		scrollToRight(titleOne,titleTwo,titleThree,sliderOne);
	}
	public void scrollToRightNewOnDemandReel(){
		scrollToRight(titleFour,titleFive,titleSix,sliderTwo);
	}
		
	public void scrollToRight(WebElement one,WebElement two,WebElement three,WebElement slider)
	{
		
		for(int i=0;i<7;i++)
		{
			hashSet.add(getAttribute("label", one));
			hashSet.add(getAttribute("label", two));
			hashSet.add(getAttribute("label", three));			
			JavascriptExecutor jsNew = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "right");			
			scrollObject.put("element", ((RemoteWebElement) slider).getId());
			jsNew.executeScript("mobile: scroll", scrollObject);
		}	
		
	}
	public void displayReelsTitleValue(WebElement slider,WebElement elementOne,WebElement elementTwo,WebElement elementThree){
//		for(int i=0;i<7;i++)
//		{
//			map.put(elementOne.getAttribute("label"),elementOne.getAttribute("value"));
//			map.put(elementTwo.getAttribute("label"),elementTwo.getAttribute("value"));
//			map.put(elementThree.getAttribute("label"),elementThree.getAttribute("value"));			
//			Set<String> keys = map.keySet();			
//			HashMap<String, String> scrollObject1 = new HashMap<String, String>();
//			scrollObject1.put("direction", "right");			
//			scrollObject1.put("element", ((RemoteWebElement) slider).getId());
//			js.executeScript("mobile: scroll", scrollObject1);
//		}
//				
//		Set<Entry<String, String>> entrySet = map.entrySet();
//		ArrayList<Entry<String, String>> listOfEntry = new ArrayList<Entry<String,String>>(entrySet);
//		System.out.println(listOfEntry);  
//	//	return listOfEntry;
		
		for(int i=0;i<7;i++){
			map.put(elementOne.getAttribute("label"),elementOne.getAttribute("value"));
			map.put(elementTwo.getAttribute("label"),elementTwo.getAttribute("value"));
		    map.put(elementThree.getAttribute("label"),elementThree.getAttribute("value"));
			
			
			//System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("label"));
			//System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("value"));
			Set<String> keys = map.keySet();
			
			Iterator<String> keyIter = keys.iterator();
			while (keyIter.hasNext()) {
		        String key = keyIter.next();
		        String value = map.get(key);

		      //  System.out.println(key + "\t" + value);

		       // String nextValue = map.get(key);
		      //  hashSetNew.add(value);
//		        if (value.equals(nextValue)) {
//		            map.remove(key);
//		        }
		        
		    }
			HashMap<String, String> scrollObject1 = new HashMap<String, String>();
			scrollObject1.put("direction", "right");			
			scrollObject1.put("element", ((RemoteWebElement) slider).getId());
			js.executeScript("mobile: scroll", scrollObject1);
		}
		Set<Entry<String, String>> entrySet = map.entrySet();
		ArrayList<Entry<String, String>> listOfEntry = new ArrayList<Entry<String,String>>(entrySet);
         System.out.println(listOfEntry);  
		  
    }
	
	public void getTitleValueofNewAtBox(){
		displayReelsTitleValue(sliderOne,titleOne,titleTwo,titleThree);
	}
	public void getTitleValueofNewOnDemand(){
		displayReelsTitleValue(sliderTwo,titleFour,titleFive,titleSix);
	}
	
	public void getTitleValueofNewTVTVTab(){
		displayReelsTitleValue(gamesSlider1,titleOne,titleTwo,titleThree);
	}
	public void getTitleValueofNewPS4GamesTab(){
		displayReelsTitleValue(gamesSlider1,titleOne,titleTwo,titleThree);
	}
	public void getTitleValueofNewXBOXOneTab(){
		displayReelsTitleValue(gamesSlider2,titleFour,titleFive,titleSix);
	}
	public void getTitleValueofNewXBOX360GamesTab(){
		displayReelsTitleValue(gamesSlider3,titleSeven,titleEight,titleNine);
	}
	
}
	
	

