package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Customer
import mappings.FirstName.{firstNameMinLength, firstNameMaxLength}
import constraints.FirstName.validFirstName

object CustomerRepository extends Controller {

  val customerForm = Form(
    mapping(
      "firstName" -> (nonEmptyText(firstNameMinLength, firstNameMaxLength) verifying validFirstName),
      "middleName" -> optional(text)
    )(Customer.apply)(Customer.unapply)
  )

  def present = Action {
    Ok(views.html.customerRepository(customerForm))
  }

  def submit = Action {
    implicit request => customerForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.customerRepository(formWithErrors)),
      f => Ok(views.html.success())
    )
  }
}