package controllers

import play.api.mvc.{Action, Controller}

class Start extends Controller {

  def present = Action {
    Ok(views.html.start())
  }
}
