package Integration

import org.specs2.mutable.Specification
import play.api.test.WithBrowser

class CustomerRepositoryIntegrationSpec extends Specification {

  "go to page" should {
    "display the page" in new WithBrowser {
      val customerRepository = "http://localhost:" + port + "/customer-repository"

      browser.goTo(customerRepository)

      browser.pageSource must contain("Add a new customer")
    }
  }

  "back button" should {
    "display the start page" in new WithBrowser {
      val customerRepository = "http://localhost:" + port + "/customer-repository"

      browser.goTo(customerRepository)

      browser.click("#back")

      browser.pageSource must contain("Welcome to the customer repository")
    }
  }


}
