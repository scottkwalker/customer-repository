package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Customer

object Application extends Controller {

  val customerForm = Form(
    "firstName" -> nonEmptyText
  )

  def index = Action {
    Redirect(routes.Application.customers)
  }

  def customers = Action {
    Ok(views.html.index(Customer.all(), customerForm))
  }

  def newCustomer = Action { implicit request =>
    customerForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(Customer.all(), errors)),
      label => {
        Customer.create(label)
        Redirect(routes.Application.customers)
      }
    )
  }

  def deleteCustomer(id: Long) = TODO

}