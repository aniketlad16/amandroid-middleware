
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/conf/routes
// @DATE:Mon Jul 18 14:25:25 EDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:18
  DBController_3: controllers.DBController,
  // @LINE:30
  CountController_0: controllers.CountController,
  // @LINE:32
  AsyncController_2: controllers.AsyncController,
  // @LINE:35
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:18
    DBController_3: controllers.DBController,
    // @LINE:30
    CountController_0: controllers.CountController,
    // @LINE:32
    AsyncController_2: controllers.AsyncController,
    // @LINE:35
    Assets_4: controllers.Assets
  ) = this(errorHandler, HomeController_1, DBController_3, CountController_0, AsyncController_2, Assets_4, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, DBController_3, CountController_0, AsyncController_2, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """result""", """controllers.HomeController.result"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """crawl/""" + "$" + """applicationName<[^/]+>""", """controllers.HomeController.crawl(applicationName:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """fileUpload""", """controllers.HomeController.fileUpload"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """configSetup""", """controllers.HomeController.configSetup"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apkfile/add""", """controllers.DBController.create(hashnumber:String, apklocation:String, appname:String, packagename:String, devname:String, price:String, uploaddate:String, size:String, noofdownloads:String, crawldate:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apkfile/""", """controllers.DBController.createFromJson"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apkfile/bulk""", """controllers.DBController.createBulkFromJson"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apkfile""", """controllers.DBController.findByName(hashnumber:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apkfile/find{hashidlist}""", """controllers.DBController.findrecords(hashidlist:List[String])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_result1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("result")))
  )
  private[this] lazy val controllers_HomeController_result1_invoker = createInvoker(
    HomeController_1.result,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "result",
      Nil,
      "POST",
      """result route""",
      this.prefix + """result"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_crawl2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("crawl/"), DynamicPart("applicationName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_crawl2_invoker = createInvoker(
    HomeController_1.crawl(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "crawl",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """crawl/""" + "$" + """applicationName<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_fileUpload3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("fileUpload")))
  )
  private[this] lazy val controllers_HomeController_fileUpload3_invoker = createInvoker(
    HomeController_1.fileUpload,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "fileUpload",
      Nil,
      "POST",
      """""",
      this.prefix + """fileUpload"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_configSetup4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("configSetup")))
  )
  private[this] lazy val controllers_HomeController_configSetup4_invoker = createInvoker(
    HomeController_1.configSetup,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "configSetup",
      Nil,
      "POST",
      """""",
      this.prefix + """configSetup"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_DBController_create5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apkfile/add")))
  )
  private[this] lazy val controllers_DBController_create5_invoker = createInvoker(
    DBController_3.create(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DBController",
      "create",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),
      "POST",
      """""",
      this.prefix + """apkfile/add"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_DBController_createFromJson6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apkfile/")))
  )
  private[this] lazy val controllers_DBController_createFromJson6_invoker = createInvoker(
    DBController_3.createFromJson,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DBController",
      "createFromJson",
      Nil,
      "POST",
      """""",
      this.prefix + """apkfile/"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_DBController_createBulkFromJson7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apkfile/bulk")))
  )
  private[this] lazy val controllers_DBController_createBulkFromJson7_invoker = createInvoker(
    DBController_3.createBulkFromJson,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DBController",
      "createBulkFromJson",
      Nil,
      "POST",
      """""",
      this.prefix + """apkfile/bulk"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_DBController_findByName8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apkfile")))
  )
  private[this] lazy val controllers_DBController_findByName8_invoker = createInvoker(
    DBController_3.findByName(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DBController",
      "findByName",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """apkfile"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_DBController_findrecords9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apkfile/find{hashidlist}")))
  )
  private[this] lazy val controllers_DBController_findrecords9_invoker = createInvoker(
    DBController_3.findrecords(fakeValue[List[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DBController",
      "findrecords",
      Seq(classOf[List[String]]),
      "GET",
      """""",
      this.prefix + """apkfile/find{hashidlist}"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_CountController_count10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count10_invoker = createInvoker(
    CountController_0.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_AsyncController_message11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message11_invoker = createInvoker(
    AsyncController_2.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_Assets_versioned12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned12_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:10
    case controllers_HomeController_result1_route(params) =>
      call { 
        controllers_HomeController_result1_invoker.call(HomeController_1.result)
      }
  
    // @LINE:12
    case controllers_HomeController_crawl2_route(params) =>
      call(params.fromPath[String]("applicationName", None)) { (applicationName) =>
        controllers_HomeController_crawl2_invoker.call(HomeController_1.crawl(applicationName))
      }
  
    // @LINE:14
    case controllers_HomeController_fileUpload3_route(params) =>
      call { 
        controllers_HomeController_fileUpload3_invoker.call(HomeController_1.fileUpload)
      }
  
    // @LINE:16
    case controllers_HomeController_configSetup4_route(params) =>
      call { 
        controllers_HomeController_configSetup4_invoker.call(HomeController_1.configSetup)
      }
  
    // @LINE:18
    case controllers_DBController_create5_route(params) =>
      call(params.fromQuery[String]("hashnumber", None), params.fromQuery[String]("apklocation", None), params.fromQuery[String]("appname", None), params.fromQuery[String]("packagename", None), params.fromQuery[String]("devname", None), params.fromQuery[String]("price", None), params.fromQuery[String]("uploaddate", None), params.fromQuery[String]("size", None), params.fromQuery[String]("noofdownloads", None), params.fromQuery[String]("crawldate", None)) { (hashnumber, apklocation, appname, packagename, devname, price, uploaddate, size, noofdownloads, crawldate) =>
        controllers_DBController_create5_invoker.call(DBController_3.create(hashnumber, apklocation, appname, packagename, devname, price, uploaddate, size, noofdownloads, crawldate))
      }
  
    // @LINE:20
    case controllers_DBController_createFromJson6_route(params) =>
      call { 
        controllers_DBController_createFromJson6_invoker.call(DBController_3.createFromJson)
      }
  
    // @LINE:22
    case controllers_DBController_createBulkFromJson7_route(params) =>
      call { 
        controllers_DBController_createBulkFromJson7_invoker.call(DBController_3.createBulkFromJson)
      }
  
    // @LINE:24
    case controllers_DBController_findByName8_route(params) =>
      call(params.fromQuery[String]("hashnumber", None)) { (hashnumber) =>
        controllers_DBController_findByName8_invoker.call(DBController_3.findByName(hashnumber))
      }
  
    // @LINE:26
    case controllers_DBController_findrecords9_route(params) =>
      call(params.fromQuery[List[String]]("hashidlist", None)) { (hashidlist) =>
        controllers_DBController_findrecords9_invoker.call(DBController_3.findrecords(hashidlist))
      }
  
    // @LINE:30
    case controllers_CountController_count10_route(params) =>
      call { 
        controllers_CountController_count10_invoker.call(CountController_0.count)
      }
  
    // @LINE:32
    case controllers_AsyncController_message11_route(params) =>
      call { 
        controllers_AsyncController_message11_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:35
    case controllers_Assets_versioned12_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned12_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
