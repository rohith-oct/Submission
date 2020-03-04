package com.page.objects;

public class AppConstants {
	
	public static final String URL="https://developer.here.com/documentation";
	public static final String ExpectedTitle="Documentation, Code Examples and API References - HERE Developer";
	public static final int ExpectedResponseCode=200;
	public static final String Links_XPATH="//div[ @class='documentation-link-wrapper']/div/div[contains(@class,'documentation-link-group')]//a[ @target='_self']";
	public static final String DropDownLinks_XPATH="//div[@class='cta cta--inline cta--developer cta__content']/ul/li//a[@target='_self']";
}
