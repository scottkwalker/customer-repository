package controllers

import org.scalatest.{Matchers, WordSpec}
import helpers.CustomerRepository.{firstNameBlank, firstNameValid, lastNameBlank, lastNameValid}

class CustomerRepositoryFormSpec extends WordSpec with Matchers {

  "customer form" should {

    "reject if fields blank" in {
      nameFiller(firstName = firstNameBlank, lastName = lastNameBlank).fold(
        formWithErrors => formWithErrors.errors.length should equal(4),
        f => fail("An error should occur")
      )
    }

    "reject if first name is less than min length" in {
      nameFiller(firstName = "a", lastName = lastNameValid).fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "reject if last name is less than min length" in {
      nameFiller(firstName = firstNameValid, lastName = "a").fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "reject if first name is more than min length" in {
      nameFiller(firstName = "a" * 51, lastName = lastNameValid).fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "reject if last name is more than min length" in {
      nameFiller(firstName = firstNameValid, lastName = "a" * 51).fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }

    "accept if valid first and last name entered" in {
      nameFiller(firstName = firstNameValid, lastName = lastNameValid).fold(
        formWithErrors => fail("An error should occur"),
        f => {
          f.firstName should equal(firstNameValid)
          f.lastName should equal(lastNameValid)
        }
      )
    }
  }

  def nameFiller(firstName: String, lastName: String = "") = {
    CustomerRepository.customerForm.bind(
      Map(
        "firstName" -> firstName,
        "lastName" -> lastName
      )
    )
  }
}