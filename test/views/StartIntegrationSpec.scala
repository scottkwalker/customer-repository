package views

import org.specs2.mutable.Specification
import play.api.test.WithBrowser

class StartIntegrationSpec extends Specification {

  "go to page" should {
    "display the page" in new WithBrowser{
      val startPage = "http://localhost:" + port
      browser.goTo(startPage)

      browser.pageSource must contain("Welcome to the customer repository")
    }
  }
  "next button" should {
    "display the customer repository page" in new WithBrowser {
      val customerRepository = "http://localhost:" + port
      browser.goTo(customerRepository)

      browser.click("#next")

      browser.pageSource must contain("Add a new customer")
    }
  }

}
