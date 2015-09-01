package dao

import slick.driver.MySQLDriver.api._
 
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
 
 
abstract class AbstractDao[E, T <: Table[E], K] {
  val db = Database.forConfig("mydb") 
  val table: TableQuery[T] 
  def filterQuery(id: K): Query[T, E, Seq]
 
  def fetchAll() =
    db.run(table.result)
 
  def fetchById(id: K): Future[Seq[E]] =
    db.run(filterQuery(id).result)
 
  def fetchOneById(id: K): Future[Option[E]] =
    db.run(filterQuery(id).result).map(_.headOption)
 
  def insert(item: E): Future[Int] =
    db.run(table += item)
 
  def update(id: K, item: E): Future[Int] =
    db.run(filterQuery(id).update(item))
 
  def remove(id: K): Future[Int] =
    db.run(filterQuery(id).delete)
    
}