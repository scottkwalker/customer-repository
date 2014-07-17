package Integration

import org.specs2.mutable.Specification
import play.api.test.WithBrowser
import helpers.CustomerRepository.customerRepositoryUrl
import helpers.Common.localHost
import helpers.CustomerRepository.{firstNameBlank, firstNameValid, firstNameTextBox, addCustomerButton, backButton, lastNameValid, lastNameTextBox}
import helpers.{CustomerRepository, Start, Success}

class CustomerRepositoryIntegrationSpec extends Specification {

  "go to page" should {
    "display the page" in new WithBrowser {
      browser.goTo(localHost + port + customerRepositoryUrl)

      browser.pageSource must contain(CustomerRepository.title)
    }
  }

  "back button" should {
    "display the start page" in new WithBrowser {
      browser.goTo(localHost + port + customerRepositoryUrl)

      browser.click(backButton)

      browser.pageSource must contain(Start.title)
    }
  }

  "submit" should {
    "redirect to success on correct input" in new WithBrowser {
      browser.goTo(localHost + port + customerRepositoryUrl)
      browser.fill(firstNameTextBox) `with` firstNameValid
      browser.fill(lastNameTextBox) `with` lastNameValid

      browser.click(addCustomerButton)

      browser.pageSource must contain(Success.title)
    }

    "stay on customer repository on incorrect input" in new WithBrowser {
      browser.goTo(localHost + port + customerRepositoryUrl)
      browser.fill(firstNameTextBox) `with` firstNameBlank

      browser.click(addCustomerButton)

      browser.pageSource must contain(CustomerRepository.title)
    }
  }
}