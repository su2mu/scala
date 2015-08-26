import slick.driver.MySQLDriver.simple._
import slick.jdbc.{GetResult => GR}

abstract class RichTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
  val id: Column[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
}