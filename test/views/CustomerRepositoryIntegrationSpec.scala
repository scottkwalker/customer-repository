package Integration

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._

@RunWith(classOf[JUnitRunner])
class CustomerRepositoryIntegrationSpec extends Specification {

  "go to page" should {
    "display the page" in new WithBrowser {
      val customerRepository = "http://localhost:" + port + "/customer-repository"

      browser.goTo(customerRepository)

      browser.pageSource must contain("Add a new customer")
    }
  }
}
