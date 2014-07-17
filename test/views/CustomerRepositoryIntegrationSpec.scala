package Integration

import org.specs2.mutable.Specification
import play.api.test.WithBrowser
import helpers.CustomerRepository
import helpers.Start

class CustomerRepositoryIntegrationSpec extends Specification {

  "go to page" should {
    "display the page" in new WithBrowser {
      val customerRepository = "http://localhost:" + port + "/customer-repository"
      browser.goTo(customerRepository)

      browser.pageSource must contain(CustomerRepository.title)
    }
  }

  "back button" should {
    "display the start page" in new WithBrowser {
      val customerRepository = "http://localhost:" + port + "/customer-repository"
      browser.goTo(customerRepository)

      browser.click(CustomerRepository.back)

      browser.pageSource must contain(Start.title)
    }
  }

  "submit button" should {
    "display an error message when mandatory fields are not filled in" in new WithBrowser {
      val customerRepository = "http://localhost:" + port + "/customer-repository"
      browser.goTo(customerRepository)

      browser.click(CustomerRepository.addCustomer)

      browser.pageSource must contain(CustomerRepository.firstNameError)
    }
  }
}
