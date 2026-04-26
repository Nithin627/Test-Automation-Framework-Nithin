package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.Users;

public class ExcelReaderUtility {

	public static Iterator<Users> readExcelFile(String fileName) {

		File xlsxFile = new File(System.getProperty("user.dir") + "/testData/" + fileName);
		XSSFWorkbook xssfWrokBook;
		XSSFSheet sheet;
		List<Users> userList = null;
		Row row;
		Cell emailCell;
		Cell passwordCell;
		Users user;

		try {
			xssfWrokBook = new XSSFWorkbook(xlsxFile);

			userList = new ArrayList<>();

			sheet = xssfWrokBook.getSheet("LoginTestData");
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next(); // Skipping first row
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new Users(emailCell.toString(), passwordCell.toString());
				userList.add(user);

			}

			xssfWrokBook.close();

		} catch (IOException | InvalidFormatException e) {

			e.printStackTrace();
		}

		return userList.iterator();

	}

}
