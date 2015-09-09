package controllers

/**
 * ① パッケージのインポート
 */
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick._
import models._
import play.api.i18n.{ MessagesApi, I18nSupport }
import daos._
import slick.driver.JdbcProfile
import models.Tables._
import forms.ControllerForm._
import javax.inject.Inject
import scala.util.{ Success, Failure }
import slick.driver.MySQLDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * ② コントローラーオブジェクトの定義
 */
class OrderingController @Inject() (orderDao: OrderDao, val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * ④ 顧客情報登録フォーム表示アクションメソッドの定義
   */
  def showCreateForm() = Action { implicit rs =>
    Ok(views.html.orderingCreateForm(orderingForm))
  }
  /**
   * ⑤ 顧客情報登録アクションメソッドの定義
   */
  def create() = Action { implicit rs =>
    orderingForm.bindFromRequest.fold(
      errors => BadRequest(views.html.orderingCreateForm(errors)),
      ordering => {
        orderDao.insert(ordering)
        Redirect(routes.OrderingController.search(""))
      })
  }

  /**
   * ⑥ 顧客情報検索アクションメソッドの定義
   */
  def search(word: String) = Action.async {implicit rs =>
    orderDao.search1(word).map {
      ret => Ok(views.html.orderingSearch(word, ret))
    }
  }


  /**
   * ⑨ 顧客情報削除アクションメソッドの定義
   */
  def remove(ID: Long) = Action {
    orderDao.remove(ID)
    Redirect(routes.OrderingController.search())
  }

}
