package constraints

import play.api.data.validation.{ValidationError, Invalid, Valid, Constraint}
import mappings.MiddleName.middleNameRegex

object MiddleName {

  def validMiddleName: Constraint[String] = Constraint[String]("constraint.validMiddleName") { input =>
    middleNameRegex.pattern.matcher(input).matches match {
      case true => Valid
      case false => Invalid(ValidationError("error.validMiddleName"))
    }
  }
}
