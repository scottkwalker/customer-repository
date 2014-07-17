package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Customer
import mappings.FirstName.firstNameRule

object CustomerRepository extends Controller {

  val customerForm = Form(
    mapping(
      "firstName" -> firstNameRule
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