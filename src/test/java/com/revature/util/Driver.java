package com.revature.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Driver {
	private static final ChromeDriver driver = null;
	private static ChromeOptions options;

	private Driver() {
		System.out.println("Driver constructing...");
		String args = "user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data";
		options = new ChromeOptions().addArguments(args);
	}

	public static ChromeDriver getInstance() {
		// Multi-OS support:
		String os = System.getProperty("os.name");
		String path = "src/main/resources/chromedriver.exe";
		if (os.equals("Linux"))
			path = "src/main/resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);

		return new ChromeDriver(options);
	}
}
