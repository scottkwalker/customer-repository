package constraints

import play.api.data.validation.{ValidationError, Invalid, Valid, Constraint}
import mappings.FirstName._

object LastName {

  def validLastName: Constraint[String] = Constraint[String]("constraint.validLastName") { input =>
    firstNameRegex.pattern.matcher(input).matches match {
      case true => Valid
      case false => Invalid(ValidationError("error.validLastName"))
    }
  }
}
