
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/conf/routes
// @DATE:Mon Jul 18 14:25:25 EDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:35
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseDBController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def createBulkFromJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DBController.createBulkFromJson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "apkfile/bulk"})
        }
      """
    )
  
    // @LINE:26
    def findrecords: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DBController.findrecords",
      """
        function(hashidlist0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apkfile/find{hashidlist}" + _qS([(""" + implicitly[QueryStringBindable[List[String]]].javascriptUnbind + """)("hashidlist", hashidlist0)])})
        }
      """
    )
  
    // @LINE:18
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DBController.create",
      """
        function(hashnumber0,apklocation1,appname2,packagename3,devname4,price5,uploaddate6,size7,noofdownloads8,crawldate9) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "apkfile/add" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hashnumber", hashnumber0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("apklocation", apklocation1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("appname", appname2), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("packagename", packagename3), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("devname", devname4), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("price", price5), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("uploaddate", uploaddate6), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("size", size7), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("noofdownloads", noofdownloads8), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("crawldate", crawldate9)])})
        }
      """
    )
  
    // @LINE:24
    def findByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DBController.findByName",
      """
        function(hashnumber0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apkfile" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hashnumber", hashnumber0)])})
        }
      """
    )
  
    // @LINE:20
    def createFromJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DBController.createFromJson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "apkfile/"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def crawl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.crawl",
      """
        function(applicationName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "crawl/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("applicationName", encodeURIComponent(applicationName0))})
        }
      """
    )
  
    // @LINE:10
    def result: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.result",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "result"})
        }
      """
    )
  
    // @LINE:14
    def fileUpload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.fileUpload",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "fileUpload"})
        }
      """
    )
  
    // @LINE:16
    def configSetup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.configSetup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "configSetup"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:32
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }


}
