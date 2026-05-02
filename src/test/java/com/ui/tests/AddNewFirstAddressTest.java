package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Address;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myyAccountPage;
	private AddressPage addressPage;
	private Address address;

	@BeforeMethod(description = "Valid user logs into the application")
	public void setUp() {
		myyAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("yatese2929@mugstock.com", "nithin@123");
//		address = new Address("CTS", "Address line 1", "Address line 2", "Banglore", "12345", "123456", "1234567890",
//				"Other information", "address alias", "California");

		address = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAdress() {
//		addressPage = 
		String newAddress=myyAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());

	}

}
