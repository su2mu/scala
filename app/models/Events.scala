package models

import play.api.db.DB
import play.api.Play.current
import play.Logger
import slick.driver.MySQLDriver.simple._
import models.Tables.{ Event, EventRow }
//import slick.jdbc.meta.{ MTable, createModel }
import slick.jdbc.meta.MTable
import scala.slick.driver.JdbcDriver

object EventsModel {
  lazy val customerQuery = TableQuery[Event]

  /**
   * キーワード検索
   * @param word
   */
  //def search(word: String)(implicit s: Session): List[Event] = {
    //customerQuery.filter(row => (row.eventNm like "%" + word + "%")).list
  //}

  /**
   * ID検索
   * @param ID
   */
  //def searchByID(ID: Int)(implicit s: Session): Event = {
    //customerQuery.filter(_.id == ID)
  //}

}


