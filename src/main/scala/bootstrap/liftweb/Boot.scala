package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._
import common._
import http._
import js.jquery.JQueryArtifacts
import net.liftmodules.JQueryModule
import net.liftmodules.validate.Validate
import net.liftmodules.validate.options.Bs3Options
import net.liftweb.sitemap.{ SiteMap, Menu }

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {

    // where to search snippet
    LiftRules.addToPackages("com.github.limansky")

    // Build SiteMap
    def sitemap = SiteMap(
      Menu.i("index") / "index",
      Menu.i("ajax") / "ajax"
    )

    LiftRules.setSiteMap(sitemap)

    // Initialize Validate
    Validate.options.default.set(Bs3Options())
    Validate.init()

    //Init the jQuery module, see http://liftweb.net/jquery for more information.
    LiftRules.jsArtifacts = JQueryArtifacts
    JQueryModule.InitParam.JQuery=JQueryModule.JQuery111Z
    JQueryModule.init()

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))
  }

}
