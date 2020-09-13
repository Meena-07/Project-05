package org.facebook;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	static WebDriver driver;

	public static void screensht(String scrname) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("G:\\eclipse works\\Facebook\\Screenshot\\" + scrname + ".png");
		FileUtils.copyFile(src, des);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\eclipse works\\Facebook\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("meenaezhil7@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Meena1907$");
		screensht("Entering username and password");
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(2000);
		screensht("Homepage");
		driver.close();

	}

}
