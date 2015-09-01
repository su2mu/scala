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
  lazy val schema = Companies.schema ++ HostBranch.schema ++ HostMachine.schema ++ Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Companies
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true) */
  case class CompaniesRow(id: Long, name: String)
  /** GetResult implicit for fetching CompaniesRow objects using plain SQL queries */
  implicit def GetResultCompaniesRow(implicit e0: GR[Long], e1: GR[String]): GR[CompaniesRow] = GR{
    prs => import prs._
    CompaniesRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table companies. Objects of this class serve as prototypes for rows in queries. */
  class Companies(_tableTag: Tag) extends Table[CompaniesRow](_tableTag, "companies") {
    def * = (id, name) <> (CompaniesRow.tupled, CompaniesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> CompaniesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(VARCHAR), Length(255,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table Companies */
  lazy val Companies = new TableQuery(tag => new Companies(tag))

  /** Entity class storing rows of table HostBranch
   *  @param id Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey
   *  @param branchName Database column branch_name SqlType(VARCHAR), Length(128,true), Default(None)
   *  @param hostMachineId Database column host_machine_id SqlType(INT) */
  case class HostBranchRow(id: Long, branchName: Option[String] = None, hostMachineId: Int)
  /** GetResult implicit for fetching HostBranchRow objects using plain SQL queries */
  implicit def GetResultHostBranchRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Int]): GR[HostBranchRow] = GR{
    prs => import prs._
    HostBranchRow.tupled((<<[Long], <<?[String], <<[Int]))
  }
  /** Table description of table host_branch. Objects of this class serve as prototypes for rows in queries. */
  class HostBranch(_tableTag: Tag) extends Table[HostBranchRow](_tableTag, "host_branch") {
    def * = (id, branchName, hostMachineId) <> (HostBranchRow.tupled, HostBranchRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), branchName, Rep.Some(hostMachineId)).shaped.<>({r=>import r._; _1.map(_=> HostBranchRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column branch_name SqlType(VARCHAR), Length(128,true), Default(None) */
    val branchName: Rep[Option[String]] = column[Option[String]]("branch_name", O.Length(128,varying=true), O.Default(None))
    /** Database column host_machine_id SqlType(INT) */
    val hostMachineId: Rep[Int] = column[Int]("host_machine_id")

    /** Uniqueness Index over (hostMachineId) (database name host_branch_host_machine_id_key) */
    val index1 = index("host_branch_host_machine_id_key", hostMachineId, unique=true)
  }
  /** Collection-like TableQuery object for table HostBranch */
  lazy val HostBranch = new TableQuery(tag => new HostBranch(tag))

  /** Entity class storing rows of table HostMachine
   *  @param id Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(64,true) */
  case class HostMachineRow(id: Long, name: String)
  /** GetResult implicit for fetching HostMachineRow objects using plain SQL queries */
  implicit def GetResultHostMachineRow(implicit e0: GR[Long], e1: GR[String]): GR[HostMachineRow] = GR{
    prs => import prs._
    HostMachineRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table host_machine. Objects of this class serve as prototypes for rows in queries. */
  class HostMachine(_tableTag: Tag) extends Table[HostMachineRow](_tableTag, "host_machine") {
    def * = (id, name) <> (HostMachineRow.tupled, HostMachineRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> HostMachineRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(64,true) */
    val name: Rep[String] = column[String]("name", O.Length(64,varying=true))

    /** Uniqueness Index over (name) (database name host_machine_name_key) */
    val index1 = index("host_machine_name_key", name, unique=true)
  }
  /** Collection-like TableQuery object for table HostMachine */
  lazy val HostMachine = new TableQuery(tag => new HostMachine(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param companyId Database column COMPANY_ID SqlType(BIGINT), Default(None)
   *  @param name Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
  case class UsersRow(id: Long, companyId: Option[Long] = None, name: Option[String] = None)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Long], e1: GR[Option[Long]], e2: GR[Option[String]]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Long], <<?[Long], <<?[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends Table[UsersRow](_tableTag, "users") {
    def * = (id, companyId, name) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), companyId, name).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column COMPANY_ID SqlType(BIGINT), Default(None) */
    val companyId: Rep[Option[Long]] = column[Option[Long]]("COMPANY_ID", O.Default(None))
    /** Database column NAME SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true), O.Default(None))

    /** Foreign key referencing Companies (database name users_ibfk_1) */
    lazy val companiesFk = foreignKey("users_ibfk_1", companyId, Companies)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
