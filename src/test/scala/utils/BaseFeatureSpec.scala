package utils

import org.scalatest.{BeforeAndAfterEach, FeatureSpec, GivenWhenThen, Matchers}
import org.scalatest.selenium.WebBrowser

/**
  * Created by Louis.Mannevy on 04/05/2017.
  */
trait BaseFeatureSpec extends FeatureSpec with GivenWhenThen with DriverInitialisation with Matchers with WebBrowser with BeforeAndAfterEach {

  override def beforeEach() = {
    driver.manage().deleteAllCookies()
    //driver.manage().window().maximize()

  }


}
