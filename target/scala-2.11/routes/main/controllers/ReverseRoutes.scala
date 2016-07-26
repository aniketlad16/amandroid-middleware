
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/conf/routes
// @DATE:Mon Jul 18 14:25:25 EDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:35
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:30
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def count(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:18
  class ReverseDBController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def createBulkFromJson(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "apkfile/bulk")
    }
  
    // @LINE:26
    def findrecords(hashidlist:List[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "apkfile/find{hashidlist}" + queryString(List(Some(implicitly[QueryStringBindable[List[String]]].unbind("hashidlist", hashidlist)))))
    }
  
    // @LINE:18
    def create(hashnumber:String, apklocation:String, appname:String, packagename:String, devname:String, price:String, uploaddate:String, size:String, noofdownloads:String, crawldate:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "apkfile/add" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hashnumber", hashnumber)), Some(implicitly[QueryStringBindable[String]].unbind("apklocation", apklocation)), Some(implicitly[QueryStringBindable[String]].unbind("appname", appname)), Some(implicitly[QueryStringBindable[String]].unbind("packagename", packagename)), Some(implicitly[QueryStringBindable[String]].unbind("devname", devname)), Some(implicitly[QueryStringBindable[String]].unbind("price", price)), Some(implicitly[QueryStringBindable[String]].unbind("uploaddate", uploaddate)), Some(implicitly[QueryStringBindable[String]].unbind("size", size)), Some(implicitly[QueryStringBindable[String]].unbind("noofdownloads", noofdownloads)), Some(implicitly[QueryStringBindable[String]].unbind("crawldate", crawldate)))))
    }
  
    // @LINE:24
    def findByName(hashnumber:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "apkfile" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hashnumber", hashnumber)))))
    }
  
    // @LINE:20
    def createFromJson(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "apkfile/")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def crawl(applicationName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "crawl/" + implicitly[PathBindable[String]].unbind("applicationName", dynamicString(applicationName)))
    }
  
    // @LINE:10
    def result(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "result")
    }
  
    // @LINE:14
    def fileUpload(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "fileUpload")
    }
  
    // @LINE:16
    def configSetup(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "configSetup")
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }

  // @LINE:32
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def message(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }


}
