package daos

import scala.concurrent.Future
import slick.driver.MySQLDriver.api._
import models.Tables._
import javax.inject.Inject
import models.Tables._
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile
import scala.util.{ Success, Failure }
import scala.concurrent.Await
import scala.concurrent.duration.Duration


class CustomerDao extends AbstractDao[CustomersRow, Customers, Long] {

  override val table = TableQuery[Customers]
  override def filterQuery(id: Long) = table.filter(_.id === id)

  def search(word: String): Future[Seq[CustomersRow]] = {
      db.run(table.filter(_.name like "%" + word + "%").result)
  }

}