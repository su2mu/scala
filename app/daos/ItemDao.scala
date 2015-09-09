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

class ItemDao extends AbstractDao[ItemsRow, Items, Long] {

  override val table = TableQuery[Items]
  override def filterQuery(id: Long) = table.filter(_.id === id)

    def search(word: String): Future[Seq[ItemsRow]] = {
      db.run(table.filter(_.name like "%" + word + "%").result)
  }
  
}