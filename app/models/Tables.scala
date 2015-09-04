package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = Customers.schema ++ Items.schema ++ Orderings.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Customers
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(64,true)
   *  @param email Database column email SqlType(VARCHAR), Length(64,true)
   *  @param tel Database column tel SqlType(VARCHAR), Length(64,true)
   *  @param address Database column address SqlType(VARCHAR), Length(64,true)
   *  @param comment Database column comment SqlType(VARCHAR), Length(64,true) */
  case class CustomersRow(id: Long, name: String, email: String, tel: String, address: String, comment: String)
  /** GetResult implicit for fetching CustomersRow objects using plain SQL queries */
  implicit def GetResultCustomersRow(implicit e0: GR[Long], e1: GR[String]): GR[CustomersRow] = GR{
    prs => import prs._
    CustomersRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table customers. Objects of this class serve as prototypes for rows in queries. */
  class Customers(_tableTag: Tag) extends Table[CustomersRow](_tableTag, "customers") {
    def * = (id, name, email, tel, address, comment) <> (CustomersRow.tupled, CustomersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(email), Rep.Some(tel), Rep.Some(address), Rep.Some(comment)).shaped.<>({r=>import r._; _1.map(_=> CustomersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(64,true) */
    val name: Rep[String] = column[String]("name", O.Length(64,varying=true))
    /** Database column email SqlType(VARCHAR), Length(64,true) */
    val email: Rep[String] = column[String]("email", O.Length(64,varying=true))
    /** Database column tel SqlType(VARCHAR), Length(64,true) */
    val tel: Rep[String] = column[String]("tel", O.Length(64,varying=true))
    /** Database column address SqlType(VARCHAR), Length(64,true) */
    val address: Rep[String] = column[String]("address", O.Length(64,varying=true))
    /** Database column comment SqlType(VARCHAR), Length(64,true) */
    val comment: Rep[String] = column[String]("comment", O.Length(64,varying=true))
  }
  /** Collection-like TableQuery object for table Customers */
  lazy val Customers = new TableQuery(tag => new Customers(tag))

  /** Entity class storing rows of table Items
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(64,true)
   *  @param price Database column price SqlType(BIGINT)
   *  @param comment Database column comment SqlType(VARCHAR), Length(64,true) */
  case class ItemsRow(id: Long, name: String, price: Long, comment: String)
  /** GetResult implicit for fetching ItemsRow objects using plain SQL queries */
  implicit def GetResultItemsRow(implicit e0: GR[Long], e1: GR[String]): GR[ItemsRow] = GR{
    prs => import prs._
    ItemsRow.tupled((<<[Long], <<[String], <<[Long], <<[String]))
  }
  /** Table description of table items. Objects of this class serve as prototypes for rows in queries. */
  class Items(_tableTag: Tag) extends Table[ItemsRow](_tableTag, "items") {
    def * = (id, name, price, comment) <> (ItemsRow.tupled, ItemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(price), Rep.Some(comment)).shaped.<>({r=>import r._; _1.map(_=> ItemsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(64,true) */
    val name: Rep[String] = column[String]("name", O.Length(64,varying=true))
    /** Database column price SqlType(BIGINT) */
    val price: Rep[Long] = column[Long]("price")
    /** Database column comment SqlType(VARCHAR), Length(64,true) */
    val comment: Rep[String] = column[String]("comment", O.Length(64,varying=true))
  }
  /** Collection-like TableQuery object for table Items */
  lazy val Items = new TableQuery(tag => new Items(tag))

  /** Entity class storing rows of table Orderings
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param customerId Database column customer_id SqlType(BIGINT)
   *  @param itemId Database column item_id SqlType(BIGINT)
   *  @param itemCount Database column item_count SqlType(BIGINT)
   *  @param comment Database column comment SqlType(VARCHAR), Length(61,true)
   *  @param createAt Database column create_at SqlType(BIGINT) */
  case class OrderingsRow(id: Long, customerId: Long, itemId: Long, itemCount: Long, comment: String, createAt: Long)
  /** GetResult implicit for fetching OrderingsRow objects using plain SQL queries */
  implicit def GetResultOrderingsRow(implicit e0: GR[Long], e1: GR[String]): GR[OrderingsRow] = GR{
    prs => import prs._
    OrderingsRow.tupled((<<[Long], <<[Long], <<[Long], <<[Long], <<[String], <<[Long]))
  }
  /** Table description of table orderings. Objects of this class serve as prototypes for rows in queries. */
  class Orderings(_tableTag: Tag) extends Table[OrderingsRow](_tableTag, "orderings") {
    def * = (id, customerId, itemId, itemCount, comment, createAt) <> (OrderingsRow.tupled, OrderingsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(customerId), Rep.Some(itemId), Rep.Some(itemCount), Rep.Some(comment), Rep.Some(createAt)).shaped.<>({r=>import r._; _1.map(_=> OrderingsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column customer_id SqlType(BIGINT) */
    val customerId: Rep[Long] = column[Long]("customer_id")
    /** Database column item_id SqlType(BIGINT) */
    val itemId: Rep[Long] = column[Long]("item_id")
    /** Database column item_count SqlType(BIGINT) */
    val itemCount: Rep[Long] = column[Long]("item_count")
    /** Database column comment SqlType(VARCHAR), Length(61,true) */
    val comment: Rep[String] = column[String]("comment", O.Length(61,varying=true))
    /** Database column create_at SqlType(BIGINT) */
    val createAt: Rep[Long] = column[Long]("create_at")

    /** Foreign key referencing Customers (database name orderings_ibfk_1) */
    lazy val customersFk = foreignKey("orderings_ibfk_1", customerId, Customers)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Items (database name orderings_ibfk_2) */
    lazy val itemsFk = foreignKey("orderings_ibfk_2", itemId, Items)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Orderings */
  lazy val Orderings = new TableQuery(tag => new Orderings(tag))
}
