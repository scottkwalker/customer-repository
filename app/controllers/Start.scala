package controllers

import play.api.mvc.{Action, Controller}

object Start extends Controller {

  def present = Action {
    Ok(views.html.start())
  }
}
