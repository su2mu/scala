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
  lazy val schema = Child.schema ++ Event.schema ++ Parent.schema ++ PlayEvolutions.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Child
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param parentId Database column parent_id SqlType(BIGINT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param createDate Database column create_date SqlType(DATETIME)
   *  @param updateDate Database column update_date SqlType(DATETIME) */
  case class ChildRow(id: Long, parentId: Option[Long] = None, name: Option[String] = None, createDate: java.sql.Timestamp, updateDate: java.sql.Timestamp)
  /** GetResult implicit for fetching ChildRow objects using plain SQL queries */
  implicit def GetResultChildRow(implicit e0: GR[Long], e1: GR[Option[Long]], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[ChildRow] = GR{
    prs => import prs._
    ChildRow.tupled((<<[Long], <<?[Long], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table child. Objects of this class serve as prototypes for rows in queries. */
  class Child(_tableTag: Tag) extends Table[ChildRow](_tableTag, "child") {
    def * = (id, parentId, name, createDate, updateDate) <> (ChildRow.tupled, ChildRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), parentId, name, Rep.Some(createDate), Rep.Some(updateDate)).shaped.<>({r=>import r._; _1.map(_=> ChildRow.tupled((_1.get, _2, _3, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column parent_id SqlType(BIGINT), Default(None) */
    val parentId: Rep[Option[Long]] = column[Option[Long]]("parent_id", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
    /** Database column create_date SqlType(DATETIME) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_date")
    /** Database column update_date SqlType(DATETIME) */
    val updateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_date")

    /** Foreign key referencing Parent (database name fk_child_parent_1) */
    lazy val parentFk = foreignKey("fk_child_parent_1", parentId, Parent)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Child */
  lazy val Child = new TableQuery(tag => new Child(tag))

  /** Entity class storing rows of table Event
   *  @param id Database column ID SqlType(INT), AutoInc, PrimaryKey
   *  @param eventId Database column EVENT_ID SqlType(VARCHAR), Length(100,true)
   *  @param eventNm Database column EVENT_NM SqlType(VARCHAR), Length(100,true) */
  case class EventRow(id: Int, eventId: String, eventNm: String)
  /** GetResult implicit for fetching EventRow objects using plain SQL queries */
  implicit def GetResultEventRow(implicit e0: GR[Int], e1: GR[String]): GR[EventRow] = GR{
    prs => import prs._
    EventRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table event. Objects of this class serve as prototypes for rows in queries. */
  class Event(_tableTag: Tag) extends Table[EventRow](_tableTag, "event") {
    def * = (id, eventId, eventNm) <> (EventRow.tupled, EventRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(eventId), Rep.Some(eventNm)).shaped.<>({r=>import r._; _1.map(_=> EventRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column EVENT_ID SqlType(VARCHAR), Length(100,true) */
    val eventId: Rep[String] = column[String]("EVENT_ID", O.Length(100,varying=true))
    /** Database column EVENT_NM SqlType(VARCHAR), Length(100,true) */
    val eventNm: Rep[String] = column[String]("EVENT_NM", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Event */
  lazy val Event = new TableQuery(tag => new Event(tag))

  /** Entity class storing rows of table Parent
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(255,true)
   *  @param createDate Database column create_date SqlType(DATETIME)
   *  @param updateDate Database column update_date SqlType(DATETIME) */
  case class ParentRow(id: Long, name: String, createDate: java.sql.Timestamp, updateDate: java.sql.Timestamp)
  /** GetResult implicit for fetching ParentRow objects using plain SQL queries */
  implicit def GetResultParentRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[ParentRow] = GR{
    prs => import prs._
    ParentRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table parent. Objects of this class serve as prototypes for rows in queries. */
  class Parent(_tableTag: Tag) extends Table[ParentRow](_tableTag, "parent") {
    def * = (id, name, createDate, updateDate) <> (ParentRow.tupled, ParentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(createDate), Rep.Some(updateDate)).shaped.<>({r=>import r._; _1.map(_=> ParentRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column create_date SqlType(DATETIME) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_date")
    /** Database column update_date SqlType(DATETIME) */
    val updateDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("update_date")
  }
  /** Collection-like TableQuery object for table Parent */
  lazy val Parent = new TableQuery(tag => new Parent(tag))

  /** Entity class storing rows of table PlayEvolutions
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param hash Database column hash SqlType(VARCHAR), Length(255,true)
   *  @param appliedAt Database column applied_at SqlType(TIMESTAMP)
   *  @param applyScript Database column apply_script SqlType(TEXT), Default(None)
   *  @param revertScript Database column revert_script SqlType(TEXT), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastProblem Database column last_problem SqlType(TEXT), Default(None) */
  case class PlayEvolutionsRow(id: Int, hash: String, appliedAt: java.sql.Timestamp, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
  /** GetResult implicit for fetching PlayEvolutionsRow objects using plain SQL queries */
  implicit def GetResultPlayEvolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[PlayEvolutionsRow] = GR{
    prs => import prs._
    PlayEvolutionsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class PlayEvolutions(_tableTag: Tag) extends Table[PlayEvolutionsRow](_tableTag, "play_evolutions") {
    def * = (id, hash, appliedAt, applyScript, revertScript, state, lastProblem) <> (PlayEvolutionsRow.tupled, PlayEvolutionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem).shaped.<>({r=>import r._; _1.map(_=> PlayEvolutionsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(VARCHAR), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(TIMESTAMP) */
    val appliedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("applied_at")
    /** Database column apply_script SqlType(TEXT), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Default(None))
    /** Database column revert_script SqlType(TEXT), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(TEXT), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Default(None))
  }
  /** Collection-like TableQuery object for table PlayEvolutions */
  lazy val PlayEvolutions = new TableQuery(tag => new PlayEvolutions(tag))
}
