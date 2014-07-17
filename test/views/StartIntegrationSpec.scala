package views

import org.specs2.mutable.Specification
import play.api.test.WithBrowser
import helpers.Start
import helpers.CustomerRepository

class StartIntegrationSpec extends Specification {

  "go to page" should {
    "display the page" in new WithBrowser{
      val startPage = "http://localhost:" + port
      browser.goTo(startPage)

      browser.pageSource must contain(Start.title)
    }
  }
  "next button" should {
    "display the customer repository page" in new WithBrowser {
      val startPage = "http://localhost:" + port
      browser.goTo(startPage)

      browser.click(Start.next)

      browser.pageSource must contain(CustomerRepository.title)
    }
  }
}