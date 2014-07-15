package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import controllers.CustomerRepository

@RunWith(classOf[JUnitRunner])
class CustomerRepositoryUnitSpec extends Specification {

  "present" should {
    "display the page" in new WithApplication {
      val result = CustomerRepository.present(FakeRequest())
      status(result) should beEqualTo(OK)
    }
  }
}