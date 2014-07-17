package Integration

import org.specs2.mutable.Specification
import play.api.test.WithBrowser
import helpers.CustomerRepository.customerRepositoryUrl
import helpers.Common.localHost
import helpers.{CustomerRepository, Start}

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

      browser.click(CustomerRepository.back)

      browser.pageSource must contain(Start.title)
    }
  }
}