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
import forms.ControllerForm._
import javax.inject.Inject
import scala.util.{Success, Failure}

/**
 * ② コントローラーオブジェクトの定義
 */
class CustomerController @Inject() (customerDao: CustomerDao, val messagesApi: MessagesApi) extends Controller with I18nSupport {

  /**
   * ④ 顧客情報登録フォーム表示アクションメソッドの定義
   */
  def showCreateForm() = Action { implicit rs =>
    Ok(views.html.customerCreateForm(customerForm))
  }
  /**
   * ⑤ 顧客情報登録アクションメソッドの定義
   */
  def create() = Action { implicit rs =>
    customerForm.bindFromRequest.fold(
      errors => BadRequest(views.html.customerCreateForm(errors)),
      customer => {
        customerDao.insert(customer)
        Redirect(routes.CustomerController.search())
      })
  }

  /**
   * ⑥ 顧客情報検索アクションメソッドの定義
   */
  def search(word: String) = Action { implicit rs =>
    val future = customerDao.search(word)
    

    Ok(views.html.customerSearch(word, null)) 
  }

  /**
   * ⑦ 顧客情報更新フォーム表示アクションメソッドの定義
   */
  def showUpdateForm(ID: Long) = TODO

  /**
   * ⑧ 顧客情報更新アクションメソッドの定義
   */
  def update(ID: Long) = TODO

  /**
   * ⑨ 顧客情報削除アクションメソッドの定義
   */
  def remove(ID: Long) = TODO

}
