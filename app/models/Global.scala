
import play.api._
import play.api.Play.current
import play.api.db._
import play.api.Play.current
import play.api.mvc._


object Global extends GlobalSettings {

    override def onStart(app: Application) {
        Logger.info("Application has started.")
    }
    override def onStop(app: Application) {
        Logger.info("Application has stopped.")
        }
    
}