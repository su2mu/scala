import slick.driver.MySQLDriver
import slick.driver.MySQLDriver.simple._

trait CRUDModel[T <: RichTable[A], A] {

  val tableReference: TableQuery[T]

  def insert(row: T#TableElementType)(implicit s: Session) = 
    tableReference.insert(row)

  def insertAndGetId(row: T#TableElementType)(implicit s: Session) = 
    (tableReference returning tableReference.map(_.id)) += row

  def deleteById(id: Long)(implicit s: Session): Boolean = 
    tableReference.filter(_.id === id).delete == 1

  def updateById(id: Long, row: T#TableElementType)(implicit s: Session): Boolean = 
    tableReference.filter(_.id === id).update(row) == 1

  def selectById(id: Long)(implicit s: Session): Option[T#TableElementType] = 
    tableReference.filter(_.id === id).firstOption

  def existsById(id: Long)(implicit s: Session): Boolean = {
    (for {
      row <- tableReference
      if row.id === id
    } yield row).firstOption.isDefined
  }
}