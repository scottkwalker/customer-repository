package mappings

import play.api.data.Mapping
import play.api.data.Forms._

object LastName {
  val lastNameMinLength = 2
  val lastNameMaxLength = 50

  def lastName (minLength: Int = lastNameMinLength, maxLength: Int = lastNameMaxLength): Mapping[String] = {
    nonEmptyText(minLength, maxLength)
  }
}
