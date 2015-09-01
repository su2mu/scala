package dao

import scala.concurrent.Future
import slick.driver.MySQLDriver.api._
import models.Tables._
import javax.inject.Inject
import models.Tables._
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

class UserDao extends AbstractDao[UsersRow, Users, Long] {

  override val table = TableQuery[Users]
  override def filterQuery(id: Long) = table.filter(_.id === id)

}