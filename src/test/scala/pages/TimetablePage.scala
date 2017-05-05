package pages

import java.time
import java.time.format.DateTimeFormatter

import pages.Homepage
import utils.{BaseFeatureSpec, DriverInitialisation}

/**
  * Created by Louis.Mannevy on 05/05/2017.
  */
object TimetablePage extends BaseFeatureSpec with DriverInitialisation {
  def assertOutDate() = {
    val outDate = find(xpath(".//*[@class='matrix-table matrix-out']/thead/tr[1]/th[2]/div/h3")).get.underlying.getText
    outDate contains time.LocalDate.now.plusDays(1).format(DateTimeFormatter.ofPattern("d MMMM YYYY"))
  }

  def assertNumberOfAdults() = {
    val testing = find(xpath(".//*[@id='journeySummary']/div/div[2]/div[2]/div[1]/div/div[2]")).get.text
    testing should include (Homepage.noOfAdults)
  }

}
