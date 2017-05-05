package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

/**
  * Created by Louis.Mannevy on 04/05/2017.
  */

object SingletonDriver {

  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe")
  val driver: WebDriver = new ChromeDriver()
}

trait DriverInitialisation {

  implicit lazy val driver = SingletonDriver.driver

}

