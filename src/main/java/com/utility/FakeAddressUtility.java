package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.Address;

public class FakeAddressUtility {

	public static void main(String[] args) {
		getFakeAddress();
	}

	public static Address getFakeAddress() {

		Faker faker = new Faker(Locale.US);
//		System.out.println(faker.name().firstName());
//		System.out.println(faker.phoneNumber().cellPhone());

		Address address = new Address(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "Other information", "Home Address",
				faker.address().state());

		return address;
	}

}
