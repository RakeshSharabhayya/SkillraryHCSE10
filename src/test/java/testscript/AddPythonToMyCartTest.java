package testscript;

import org.testng.asserts.SoftAssert;

import genaricLibraries.BaseClass;

public class AddPythonToMyCartTest  extends BaseClass {
	public void sendContactDetailsTest() {
		SoftAssert soft=new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoAppLink();
		web.switchToChildBrowser();
		
		soft.assertTrue(demoApp.getPageHeader().contains("ECommerce"));
		
		demoApp.selectCategory(web, 1);
		
		soft.assertEquals(Testing.getPageHeader(),"Testing");
		
		web.scrollTillElement(Testing.getPythonImage());
		web.dragAndDropElement(Testing.getPythonImage(),Testing.getCartArea());
		
		web.scrollTillElement(Testing.getFacebookIcon());
		Testing.clickFacebookIcon();

		soft.assertAll();
}
}