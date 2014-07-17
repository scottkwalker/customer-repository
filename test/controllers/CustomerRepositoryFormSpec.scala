package controllers

import org.scalatest.{Matchers, WordSpec}
import helpers.CustomerRepository.{firstNameBlank, firstNameValid, middleNameBlank, middleNameValid, lastNameBlank, lastNameValid}

class CustomerRepositoryFormSpec extends WordSpec with Matchers {

  "customer form" should {
    "reject if fields blank" in {
      nameFiller(firstName = firstNameBlank).fold(
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
    "reject if first name contains special characters" in {
      nameFiller(firstName = "$%^", lastName = lastNameValid).fold(
        formWithErrors => formWithErrors.errors.length should equal(1),
        f => fail("An error should occur")
      )
    }
    "reject if middle name and last name is valid and first name is blank" in {
      nameFiller(firstName = firstNameBlank, middleName = middleNameValid, lastName = lastNameValid).fold(
        formWithErrors => formWithErrors.errors.length should equal(2),
        f => fail("An error should occur")
      )
    }
    "accept if valid first name and surname only is entered" in {
      nameFiller(firstName = firstNameValid, lastName = lastNameValid).fold(
        formWithErrors => fail("An error should occur"),
        f => {
          f.firstName should equal(firstNameValid)
          f.lastName should equal(lastNameValid)
        }
      )
    }
    "accept if valid first, middle and last names are entered" in {
      nameFiller(firstName = firstNameValid, middleName = middleNameValid, lastName = lastNameValid).fold(
        formWithErrors => fail("An error should occur"),
        f => {
          f.firstName should equal(firstNameValid)
          f.middleName should equal(Some(middleNameValid))
          f.lastName should equal(lastNameValid)
        }
      )
    }
  }

  def nameFiller(firstName: String, middleName: String = middleNameBlank, lastName: String = "") = {
    CustomerRepository.customerForm.bind(
      Map(
        "firstName" -> firstName,
        "middleName" -> middleName,
        "lastName" -> lastName
      )
    )
  }

}