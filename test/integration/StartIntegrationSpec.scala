package integration

import org.specs2.mutable.Specification
import play.api.test.WithBrowser

class StartIntegrationSpec extends Specification {

  "Start" should {
    "display the page" in new WithBrowser{
      val startPage = "http://localhost:" + port

      browser.goTo(startPage)

      browser.pageSource must contain("Welcome to the customer repository")
    }
  }
}
