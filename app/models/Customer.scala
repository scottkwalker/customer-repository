package models

case class Customer(id: Long, firstName: String)

object Customer {

  def all(): List[Customer] = Nil

  def create(firstName: String) {}

  def delete(id: Long) {}
}
