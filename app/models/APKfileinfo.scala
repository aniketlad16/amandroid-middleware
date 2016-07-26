package models

import play.api.libs.json.Json

/**
  * Created by Aniket on 6/19/16.
  */
case class APKfileinfo (hashnumber: String, apklocation: String, appname: String, packagename: String, devname: String, price: String, uploaddate: String, size: String, noofdownloads: String, crawldate: String)

object APKfileinfo {
  implicit val formatter = Json.format[APKfileinfo]
}
