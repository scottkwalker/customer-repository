package controllers

import play.api.test.{FakeRequest, WithApplication}
import play.api.test.Helpers._
import org.scalatest.{Matchers, WordSpec}

class SuccessUnitSpec extends WordSpec with Matchers {

  "present" should {
    "present the page" in new WithApplication {
      val result = Success.present(FakeRequest())
      status(result) should equal(OK)
    }
  }
}
