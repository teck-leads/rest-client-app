package com.techleads.app.model;

public class AndroidInfo {
	private String androidPackageName;

	public String getAndroidPackageName() {
		return androidPackageName;
	}

	public void setAndroidPackageName(String androidPackageName) {
		this.androidPackageName = androidPackageName;
	}

	@Override
	public String toString() {
		return "AndroidInfo [androidPackageName=" + androidPackageName + "]";
	}

}
