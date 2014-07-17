package constraints

import play.api.data.validation.{ValidationError, Invalid, Valid, Constraint}
import mappings.FirstName.firstNameRegex

object FirstName {

  def validFirstName: Constraint[String] = Constraint[String]("constraint.validFirstName") { input =>
    firstNameRegex.pattern.matcher(input).matches match {
      case true => Valid
      case false => Invalid(ValidationError("error.validFirstName"))
    }
  }

}
