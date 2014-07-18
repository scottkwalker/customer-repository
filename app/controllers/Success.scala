package controllers

import play.api.mvc.{Action, Controller}
import models.Customer

class Success (customer: Customer) extends Controller {

  def present = Action {
    Ok(views.html.success(customer))
  }
}
