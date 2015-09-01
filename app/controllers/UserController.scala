package controllers

import play.api.mvc._
import dao.UserDao
import play.api.data._
import play.api.data.Forms._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{ Failure, Success }
import scala.concurrent.ExecutionContext.Implicits.global

import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.i18n.{ MessagesApi, I18nSupport }
import play.api.db.slick._
import slick.driver.JdbcProfile
import models.Tables._
import javax.inject.Inject
import scala.concurrent.Future
import slick.driver.MySQLDriver.api._
import play.api.Play

object UserController {

  // フォームの値を格納するケースクラス
  case class UserForm(id: Option[Long], name: String, companyId: Option[Int])

  // formから送信されたデータ ⇔ ケースクラスの変換を行う
  val userForm = Form(
    mapping(
      "id" -> optional(longNumber),
      "name" -> nonEmptyText(maxLength = 20),
      "companyId" -> optional(number))(UserForm.apply)(UserForm.unapply))

}

class UserController @Inject() (userDao :UserDao) extends Controller {

  /**
   * 一覧表示
   */
  def list = Action.async {
    // IDの昇順にすべてのユーザ情報を取得
    userDao.fetchAll().map { users =>
      // 一覧画面を表示
      Ok(views.html.user.list(users))
    }
    
  }
 

}