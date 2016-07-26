
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/conf/routes
// @DATE:Mon Jul 18 14:25:25 EDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
