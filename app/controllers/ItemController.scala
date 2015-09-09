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
class ItemController @Inject() (itemDao: ItemDao, val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * ④ 顧客情報登録フォーム表示アクションメソッドの定義
   */
  def showCreateForm() = Action { implicit rs =>
    Ok(views.html.itemCreateForm(itemForm))
  }
  /**
   * ⑤ 顧客情報登録アクションメソッドの定義
   */
  def create() = Action { implicit rs =>
    itemForm.bindFromRequest.fold(
      errors => BadRequest(views.html.itemCreateForm(errors)),
      item => {
        itemDao.insert(item)
        Redirect(routes.ItemController.search(""))
      })
  }

  /**
   * ⑥ 顧客情報検索アクションメソッドの定義
   */
  def search(word: String) = Action.async {implicit rs =>
    itemDao.search(word).map {
      ret => Ok(views.html.itemSearch(word, ret))
    }
  }

  /**
   * ⑦ 顧客情報更新フォーム表示アクションメソッドの定義
   */
  def showUpdateForm(ID: Long) = Action.async {
    itemDao.fetchById(ID).map {
      x => Ok(views.html.itemUpdateForm(ID, itemForm.fill(x)))
    }

  }

  /**
   * ⑧ 顧客情報更新アクションメソッドの定義
   */
  def update(id: Long) = Action { implicit rs =>
    itemForm.bindFromRequest.fold(
      errors => Ok(views.html.itemUpdateForm(id, errors)),
      item => {
        itemDao.update(id, item)
        Redirect(routes.ItemController.search("155"))
      })
  }

  /**
   * ⑨ 顧客情報削除アクションメソッドの定義
   */
  def remove(ID: Long) = Action {
    itemDao.remove(ID)
    Redirect(routes.ItemController.search())
  }

}
