package com.ui.pojo;

public class Environment {

	private String url;
	private int MAX_TRY;
	private boolean isHeadless;

	public boolean isHeadless() {
		return isHeadless;
	}

	public void setHeadless(boolean isHeadless) {
		this.isHeadless = isHeadless;
	}

	public int getMAX_TRY() {
		return MAX_TRY;
	}

	public void setMAX_TRY(int mAX_TRY) {
		MAX_TRY = mAX_TRY;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
