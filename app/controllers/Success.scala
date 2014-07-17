package controllers

import play.api.mvc.{Action, Controller}

object Success extends Controller {

  def present = Action {
    Ok(views.html.success())
  }
}
