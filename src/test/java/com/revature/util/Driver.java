package com.revature.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Webdriver Singleton
public final class Driver extends ChromeDriver {
	private static Driver driver = null;
	private static ChromeOptions options;

	private Driver() {
	}

	private Driver(ChromeOptions options) {
		super(options);
	}

	public static Driver getInstance() {
		if (driver == null) {
			String os = System.getProperty("os.name");
			String path = "src/main/resources/chromedriver.exe";
			if (os.equals("Linux"))
				path = "src/main/resources/chromedriver";
			System.setProperty("webdriver.chrome.driver", path);

			if (true) {
				driver = new Driver(); // run locally
			} else {
				System.out.println("Driver constructing...");
				String args = "user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data";
				options = new ChromeOptions().addArguments(args);
				driver = new Driver(options);
			}
		}

		return driver;
	}
}
