package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtily;

public class MyRetryAnalyzer implements IRetryAnalyzer {
//	private static final int MAX_TRY = Integer.parseInt(PropertiesUtily.readProperty(Env.DEV, "MAX_TRY"));

	private static final int MAX_TRY = JsonUtility.readJSON(Env.QA).getMAX_TRY();
	private static int current_attempt = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (current_attempt <= MAX_TRY) {
			current_attempt++;
			return true;
		}

		return false;
	}

}
