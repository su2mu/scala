package daos

import scala.concurrent._
import slick.driver.MySQLDriver.api._
import models.Tables._
import javax.inject.Inject
import models.Tables._
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile
import scala.concurrent.duration.Duration
import forms.ControllerForm._

class OrderDao extends AbstractDao[OrderingsRow, Orderings, Long] {

  override val table = TableQuery[Orderings]
  override def filterQuery(id: Long) = table.filter(_.id === id)

  lazy val itemQuery = TableQuery[Items]
  lazy val customerQuery = TableQuery[Customers]

  def search(word: String):Future[ Seq[(Long, Long, Long, String, String, String, String, String, Long, String, Long, String, Long, String)]] = {
    val query = for {
      ordering <- table
      customer <- customerQuery.filter(_.id === ordering.customerId)
      item <- itemQuery.filter(_.id === ordering.itemId)
    } yield (ordering.id, ordering.createAt, customer.id, customer.name, customer.email, customer.tel, customer.address, customer.comment, item.id, item.name, item.price, item.comment, ordering.itemCount, ordering.comment)
    val q = query.filter(row => row._4 like "%" + word + "%")
    db.run(q.result)
  }
  
    def search1(word: String): Future[Seq[(OrderingsRow,CustomersRow,ItemsRow)]] = {
    val query = for {
      ordering <- table
      customer <- customerQuery.filter(_.id === ordering.customerId)
      item <- itemQuery.filter(_.id === ordering.itemId)
    } yield (ordering,customer,item)
    val q = query.filter(row => row._2.name like "%" + word + "%")
    db.run(q.result)
  }
  

}