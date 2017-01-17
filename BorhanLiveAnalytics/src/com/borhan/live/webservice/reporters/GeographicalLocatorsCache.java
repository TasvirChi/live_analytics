package com.borhan.live.webservice.reporters;

import com.borhan.city2Location.CityLocator;
import com.borhan.country2location.CountryLocator;

public class GeographicalLocatorsCache {
	
	protected static CityLocator cityLocator = new CityLocator();
	protected static CountryLocator countryLocator = new CountryLocator();
	
	public static CityLocator getCityLocator() {
		return cityLocator;
	}
	
	public static CountryLocator getCountryLocator() {
		return countryLocator;
	}

}
