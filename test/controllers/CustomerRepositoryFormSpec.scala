package controllers

import org.scalatest.{Matchers, WordSpec}
import helpers.CustomerRepository.{firstNameBlank, firstNameValid, middleNameBlank, middleNameValid}

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

    "reject if name contains numbers" in {
      firstNameFiller(firstName = "123456").fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "reject if name contains special characters" in {
      firstNameFiller(firstName = "$%^").fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "reject if middle name is valid and first name is blank" in {
      firstNameFiller(firstName = firstNameBlank, middleName = middleNameValid).fold(
        formWithErrors => formWithErrors.errors.length should equal(2),
        f => fail("An error should occur")
      )
    }

    "accept if valid first name only is entered" in {
      firstNameFiller(firstName = firstNameValid).fold(
        formWithErrors => fail("An error should occur"),
        f => f.firstName should equal(firstNameValid)
      )
    }

    "accept if valid first and middle names are entered" in {
      firstNameFiller(firstName = firstNameValid, middleName = middleNameValid).fold(
        formWithErrors => fail("An error should occur"),
        f => f.firstName should equal(firstNameValid)
      )
    }
  }

  def firstNameFiller(firstName: String, middleName: String = middleNameBlank) = {
    CustomerRepository.customerForm.bind(
      Map("firstName" -> firstName,
          "middleName" -> middleName)
    )
  }
}