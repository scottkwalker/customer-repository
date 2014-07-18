package controllers

import play.api.test.{FakeRequest, WithApplication}
import play.api.test.Helpers._
import org.scalatest.{Matchers, WordSpec}

class StartUnitSpec extends WordSpec with Matchers {

  "present" should {
    "present the page" in new WithApplication{
      val start = new Start

      status(start.present(FakeRequest())) should equal(OK)
    }
  }
}
