package mappings

import play.api.data.Mapping
import play.api.data.Forms._

object FirstName {
  val firstNameMinLength = 2
  val fistNameMaxLength = 50

  def firstName (minLength: Int = firstNameMinLength, maxLength: Int = fistNameMaxLength): Mapping[String] = {
    nonEmptyText(minLength, maxLength)
  }
}
