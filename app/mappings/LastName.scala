package mappings

object LastName {
  val lastNameMinLength = 2
  val lastNameMaxLength = 50
  val lastNameRegex = """^([a-zA-Z\-])*$""".r
}