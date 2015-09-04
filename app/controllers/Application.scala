package controllers

import play.api._
import play.api.mvc._
import slick.codegen.SourceCodeGenerator

class Application extends Controller {

  def index = Action {
  
    Ok(views.html.index("Your new application is ready."))
  }
  
  /** コード生成 */
  def generate = Action {
    val slickDriver = "slick.driver.MySQLDriver"
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/play3?characterEncoding=UTF-8"
    val outputFolder = "app"
    val pkg = "models"
    val user ="root"
    val password = "admin"

    SourceCodeGenerator.main(
      Array(
        slickDriver,
        jdbcDriver,
        url,
        outputFolder,
        pkg,
        user,
        password
      )
    )


    Ok(views.html.index("Your new application is ready."))
  }

}
