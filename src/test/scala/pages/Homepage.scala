package pages


import java.time.format.DateTimeFormatter
import java.time.{LocalDate, Month, Year}

import utils.BaseFeatureSpec

import scala.util.Random

/**
  * Created by Louis.Mannevy on 28/04/2017.
  */
object Homepage extends BaseFeatureSpec {

  val today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MM YYYY"))

  var noOfAdults: String = ""



  def navigateToWebPage() = {
    go to "https://www.thetrainline.com"
  }

  def defineToAndFrom() = {
     searchField("originStation").value = "Brighton"
     searchField("destinationStation").value = "London Bridge"
  }

  def assertPageTitle() = {
    assert(pageTitle.contains("Trainline"), "page title incorrect")
  }

  def checkOneWay () = {
    if(find("journey-type-single").isDefined) {
      clickOn("journey-type-return")}
  }

  def outTomorrow() = {
    click on xpath (".//*[contains(text(),'Tomorrow')")
  }

  def outNextDay() = {
    click on xpath (".//*[contains(text(),'Next day')]")
  }

  def selectDate(daysInFuture: Long) = {
    //takes current date and adds 60 days to it. Then 
  }

  def numberOfAdults() = {
    val randomRange = 1 + Random.nextInt(8)
    val numberOfAdults = randomRange.toString

    click on xpath(".//*[@id='extendedSearchForm']/div[4]/div[1]/div/button")
    singleSel("adults").value = numberOfAdults
    noOfAdults = numberOfAdults

    click on xpath(".//*[@id='extendedSearchForm']/div[4]/div[1]/div/div/button")
  }

  def submitButton() = {
    click on xpath (".//*[@id='submitButton']")
  }
}
