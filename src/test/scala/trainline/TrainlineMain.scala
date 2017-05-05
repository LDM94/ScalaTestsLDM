package trainline

import pages.Homepage
import pages.TimetablePage
import utils.BaseFeatureSpec


/**
  * Created by Louis.Mannevy on 28/04/2017.
  */
class TrainlineMain extends BaseFeatureSpec  {

  feature("Trainline.com Scala Practise"){
    scenario("Exercise One") {

      Given("I am on the trainline homepage")
      go to "https://www.thetrainline.com"

      When("I enter Brighton in the From field")
      searchField("originStation").value = "Brighton"

      And("Enter London Bridge in the To field")
      searchField("destinationStation").value = "London Bridge"

      And("I click the submit button")
      clickOn("submitButton")

      Then("The site should display the trains and times for this journey")

      driver.close()
    }

    scenario("Exercise Two"){

      Given("I am on the trainline homepage")
      go to "https://www.thetrainline.com"
      assert(currentUrl startsWith "https://www.thetrainline.com")

      When("I enter Brighton in the From field")
      searchField("originStation").value = "Brighton"

      And("Enter London Bridge in the To field")
      searchField("destinationStation").value = "London Bridge"

      And("I click the submit button")
      clickOn("submitButton")

      Then("The site should display the trains and times for this journey")
      assert(find(xpath(".//*[@id='timetable']/div[2]")) isDefined)

      driver.close()
    }

   scenario("Exercise Three"){

     Given("I am on the trainline homepage")
     go to "https://www.thetrainline.com"
     assert(currentUrl startsWith "https://www.thetrainline.com")

     When("I enter Brighton in the From field")
     searchField("originStation").value = "Brighton"

     And("Enter London Bridge in the To field and deselect the one-way options to get return tickets")
     searchField("destinationStation").value = "London Bridge"
     if(find("journey-type-single").isDefined) {
       clickOn("journey-type-return")
       find(xpath(".//*[contains(text(),'Tomorrow')]")).get.underlying.click()
       find(xpath(".//*[contains(text(),'Next day')]")).get.underlying.click()
     }


     And("I click the submit button")
     clickOn("submitButton")
     find(xpath(".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")).get.underlying.getText shouldBe "Sat 29th Apr 2017"

     Then("The site should display the trains and times for this journey")
     TimetablePage.assertOutDate()

     driver.close()

    }

   scenario("Exercise Four"){

      Given("I am on the trainline homepage")
      go to "https://www.thetrainline.com"
      assert(currentUrl startsWith "https://www.thetrainline.com")

      When("I enter Brighton in the From field")
      searchField("originStation").value = "Brighton"

      And("Enter London Bridge in the To field and deselect the one-way options to get return tickets")
      searchField("destinationStation").value = "London Bridge"
      if(find("journey-type-single").isDefined) {
        clickOn("journey-type-return")
        Homepage.outTomorrow
        Homepage.outNextDay
      }


      And("I click the submit button")
      clickOn("submitButton")
      find(xpath(".//*[@id='tickets']/div/div[1]/table/thead/tr[1]/th[2]/div/h3")).get.underlying.getText shouldBe "Sat 29th Apr 2017"

      Then("The site should display the trains and times for this journey")
      //Homepage.outDateAssert should include regex  "Sat 29th Apr 2017" fix later

      driver.close()
    }

   scenario("Exercise Five"){

     Given("I am on the trainline homepage")
     Homepage.navigateToWebPage

     Then("The page title will be correct and the one way option deselected")
     Homepage.assertPageTitle
     Homepage.checkOneWay


     When("I enter Brighton in the From field and London Bridge in the To field")
     Homepage.defineToAndFrom

     And("I select a return ticket")
     Homepage.outNextDay


     And("I click the submit button")
     Homepage.submitButton


     Then("The site should display the trains and times for this journey")
     TimetablePage.assertOutDate

     driver.close()
   }

   scenario("Exercise Six") {

     Given("I am on the trainline homepage")
     Homepage.navigateToWebPage

     Then("The page title will be correct and the one way option deselected")
     Homepage.assertPageTitle
     Homepage.checkOneWay

     When("I enter Brighton in the From field and London Bridge in the To field")
     Homepage.defineToAndFrom

     And("I select a return ticket")
     Homepage.outNextDay

     //New functionality, calls a function from the homepage that selects a random number of adults and stores it in a variable
     And("I randomly select a number of adults from the dropdown field")
     Homepage.numberOfAdults

     And("I click the submit button")
     Homepage.submitButton

     Then("The site should display the trains and times for this journey AND the timetable page displays the correct number of adults")
     TimetablePage.assertOutDate
     TimetablePage.assertNumberOfAdults
     //call function that asserts the correct number of adults are displayed on the page

     driver.close

   }

   scenario("Exercise Seven"){
     Given("I am on the trainline homepage")
     Homepage.navigateToWebPage

     Then("The page title will be correct and the one way option deselected")
     Homepage.assertPageTitle
     Homepage.checkOneWay

     When("I enter Brighton in the From field and London Bridge in the To field")
     Homepage.defineToAndFrom

     And("I select a return ticket")
     Homepage.outNextDay

     //New functionality, calls a function from the homepage that selects a random number of adults and stores it in a variable
     And("I randomly select a number of adults from the dropdown field")
     Homepage.numberOfAdults

     And("I click the submit button")
     Homepage.submitButton

     Then("The site should display the trains and times for this journey AND the timetable page displays the correct number of adults")
     TimetablePage.assertOutDate
     TimetablePage.assertNumberOfAdults

     driver.close

   }
  }
}
