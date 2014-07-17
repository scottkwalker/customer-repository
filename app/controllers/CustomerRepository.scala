package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object CustomerRepository extends Controller {

  val customerForm = Form(
    "firstName" -> nonEmptyText
  )

  def present = Action {
    Ok(views.html.customerRepository(customerForm))
  }

  def submit = Action {
    implicit request =>
    customerForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.customerRepository(formWithErrors)),
      f => Ok(views.html.success())
    )
  }
}