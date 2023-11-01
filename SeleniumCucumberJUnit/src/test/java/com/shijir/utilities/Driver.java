package com.shijir.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver(){}


    private static final InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver(){

        if(driverPool.get() == null){  // if driver/browser was never opened

        String browserType = ConfigurationReader.getProperty("browser");


        switch(browserType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                driverPool.set(new ChromeDriver(ops));
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverPool.set(new FirefoxDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "headless-chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--remote-allow-origins=*");
                option.setHeadless(true);
                driverPool.set(new ChromeDriver(option));
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
        }
        }


       return driverPool.get();

    }


    public static void closeDriver(){
        if(driverPool.get() !=null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
