package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.Users;

public class CSVReaderUtility {

	public static Iterator<Users> readCSVFile(String fileName) {

		File csvfile = new File(System.getProperty("user.dir") + "/testData/" + fileName);

		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		Users userData;
		List<Users> userList = null;
		try {
			fileReader = new FileReader(csvfile);
			csvReader = new CSVReader(fileReader);
			line = csvReader.readNext();// To skip the first column

//			data = csvReader.readNext();
//			if [No row] csvReader returns null

			userList = new ArrayList<>();
			while ((line = csvReader.readNext()) != null) {

				userData = new Users(line[0], line[1]);
				userList.add(userData);

			}

//			for (Users user : userList) {
//				System.out.println(user);
//			}

		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();

		}

		return userList.iterator();

	}

}
