package controllers

import play.api.mvc.{Action, Controller}

class Success extends Controller {

  def present = Action {
    Ok(views.html.success())
  }
}
