package com.home.page.base;

import com.home.core.base.CoreBasePage;
import com.home.core.base.CoreWebDriverBase;
import core.home.dataProvider.PropertyReader;

public class HomeBasePage extends CoreBasePage {
	
	PropertyReader propertyReader= new PropertyReader();
	
	public HomeBasePage() throws Exception {
		super(CoreWebDriverBase.getCurrentDriver());
	}
	
	public boolean verifyStringValues(String expected, String actual) {
		if(expected.contentEquals(actual))
			return true;
		else
			return false;
	}
}
