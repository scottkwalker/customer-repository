package mappings

import play.api.data.Mapping
import play.api.data.Forms._
import constraints.FirstName.validFirstName

object FirstName {
  val MinLength = 2
  val MaxLength = 50
  val firstNameRegex = """^([a-zA-Z])*$""".r

  def firstNameRule: Mapping[String] = nonEmptyText(MinLength, MaxLength) verifying validFirstName
}
