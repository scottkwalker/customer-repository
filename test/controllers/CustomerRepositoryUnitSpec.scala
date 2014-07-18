package controllers

import play.api.test._
import play.api.test.Helpers._
import org.scalatest.{Matchers, WordSpec}

class CustomerRepositoryUnitSpec extends WordSpec with Matchers {

  "present" should {
    "present the page" in new WithApplication {
      val customerRepository = new CustomerRepository
      val result = customerRepository.present(FakeRequest())

      status(result) should equal(OK)
    }
  }
}