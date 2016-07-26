
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object result_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class result extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(appName: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""
"""),format.raw/*2.1*/("""<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    """),_display_(/*8.6*/appName),format.raw/*8.13*/("""
"""),format.raw/*9.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(appName:String): play.twirl.api.HtmlFormat.Appendable = apply(appName)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (appName) => apply(appName)

  def ref: this.type = this

}


}

/**/
object result extends result_Scope0.result
              /*
                  -- GENERATED --
                  DATE: Tue May 03 02:30:54 EDT 2016
                  SOURCE: /Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/app/views/result.scala.html
                  HASH: d2ad384f1c2b99adb751d9d2cdcd3e3fb9d8d1c2
                  MATRIX: 529->1|641->18|668->19|789->115|816->122|843->123
                  LINES: 20->1|25->1|26->2|32->8|32->8|33->9
                  -- GENERATED --
              */
          