package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genaricLibraries.WebDriverUtility;

	public class SeleniumTrainingPage {
		/**
		 * this class contains elements locators and respective buisness libraries of testing page
		 * @author admin
		 */
	//Declaration
		@FindBy(xpath="//h1[@class='page-header']")
		private WebElement pageHeader;
		
		@FindBy(id="quantity")
		private WebElement quantity;
		
		@FindBy(id="add")
		private WebElement plusButton;
		
		@FindBy(xpath="//button[.=' Add to Cart']")
		private WebElement addToCartButton;
		
		@FindBy(xpath="//div[@class='callout callout-success']/span")
		private WebElement itemAddedMessage;
		
		//Initialization
		public SeleniumTrainingPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		//Utilization
		/**
		 * this method returns page header text
		 * @return
		 */
		public String getPageHeader() {
			return pageHeader.getText();
		}
		/**
		 * this method is used to fetch the quantity of product
		 * @return
		 */
		
		public String getQuantity() {
			return quantity.getAttribute("value");
		}
		/**
		 * this method is used to double click on plus button
		 * @param web
		 */
		public void doubleClickPlusButton(WebDriverUtility web) {
			web.doubleClick(plusButton);
		}
		/**
		 * this method is used to click on add to cart button
		 */
		public void clickAddToCart() {
			addToCartButton.click();
		}
		/**
		 * this method i used to fetch item added message
		 * @return
		 */
		public String getItemAddedMessage() {
			return itemAddedMessage.getText();
		
		}
	}