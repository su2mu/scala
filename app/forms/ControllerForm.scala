package forms

import play.api.data._
import play.api.data.Forms._
import models.Tables._

/**
 * @author kin
 */
object ControllerForm {

  val customerForm = Form(
    mapping(
      "ID" -> longNumber,
      "name" -> nonEmptyText(maxLength = 140),
      "email" -> nonEmptyText(maxLength = 140),
      "tel" -> nonEmptyText(maxLength = 140),
      "address" -> nonEmptyText(maxLength = 140),
      "comment" -> text(maxLength = 140))(CustomersRow.apply)(CustomersRow.unapply))

  val itemForm = Form(
    mapping(
      "ID" -> longNumber,
      "name" -> nonEmptyText(maxLength = 140),
      "price" -> longNumber,
      "comment" -> text(maxLength = 140))(ItemsRow.apply)(ItemsRow.unapply))

  val orderingForm = Form(
    mapping(
      "ID" -> longNumber,
      "customerID" -> longNumber,
      "itemID" -> longNumber,
      "itemCount" -> longNumber,
      "comment" -> text(maxLength = 140),
      "createdAt" -> longNumber)(OrderingsRow.apply)(OrderingsRow.unapply))
}