package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyName) {

		File propFile = new File(System.getProperty("user.dir") + "/config/" + env + ".properties");
		Properties prop = null;
		try (FileReader fileReader = new FileReader(propFile)) {

			prop = new Properties();
			prop.load(fileReader);

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		String value = prop.getProperty(propertyName.toUpperCase());
		return value;

	}

}
