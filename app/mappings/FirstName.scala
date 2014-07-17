package mappings

object FirstName {
  val firstNameMinLength = 2
  val firstNameMaxLength = 50
  val firstNameRegex = """^([a-zA-Z])*$""".r
}
