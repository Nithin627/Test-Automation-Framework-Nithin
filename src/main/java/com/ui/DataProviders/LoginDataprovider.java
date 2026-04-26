package com.ui.DataProviders;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.Users;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataprovider {

	@DataProvider(name = "loginTestJSONDataProvider")
	public Iterator<Object[]> loginJSONDataProvider() {

		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "/testData/loginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(testDataFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

		TestData data = gson.fromJson(fileReader, TestData.class);// Deserialization -> converting the json object into
																	// a java object

		List<Object[]> dataToReturn = new ArrayList<>();

		for (Users user : data.getData()) {
			dataToReturn.add(new Object[] { user });
		}

		return dataToReturn.iterator();

	}

	@DataProvider(name = "loginTestCSVDataProvider")
	public Iterator<Users> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}

	@DataProvider(name = "loginTestExcelDataProvider")
	public Iterator<Users> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
	}

}
