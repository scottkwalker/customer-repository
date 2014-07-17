package controllers

import org.scalatest.{Matchers, WordSpec}
import helpers.CustomerRepository.{firstNameBlank, firstNameValid}

class CustomerRepositoryFormSpec extends WordSpec with Matchers {

  "customer form" should {

    "reject if blank" in {
      firstNameFiller(firstName = firstNameBlank).fold(
        formWithErrors => formWithErrors.errors.length should equal(2),
        f => fail("An error should occur")
      )
    }

    "reject if name is less than min length" in {
      firstNameFiller(firstName = "a").fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "reject if name is more than min length" in {
      firstNameFiller(firstName = "a" * 51).fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "accept if valid name entered" in {
      firstNameFiller(firstName = firstNameValid).fold(
        formWithErrors => fail("An error should occur"),
        f => f.firstName should equal(firstNameValid)
      )
    }
  }

  def firstNameFiller(firstName: String) = {
    CustomerRepository.customerForm.bind(
      Map("firstName" -> firstName)
    )
  }
}