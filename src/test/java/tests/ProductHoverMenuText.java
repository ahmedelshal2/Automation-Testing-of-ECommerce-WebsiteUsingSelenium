package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuText extends TestBase {
	HomePage homeObject;
	
	@Test(priority=1)
	public void UserCanSelectSubCategoryFromMenue()
	{
		homeObject=new HomePage(driver);
		homeObject.selectComputer();
		//Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
	@Test(priority=2)
	public void runnotebook()
	{
		homeObject=new HomePage(driver);
		homeObject.selectNoteBook();
		System.out.println(driver.getCurrentUrl());

	}

}
