package controllers

import java.util
import javax.inject._

import customUtil.Errors
import models.APKfileinfo
import play.api.Logger
import play.api.libs.json._
import play.api.mvc._
import play.modules.reactivemongo._
import reactivemongo.api.ReadPreference
import reactivemongo.play.json._
import reactivemongo.play.json.collection._

import scala.concurrent.{ExecutionContext, Future}



/**
  * Created by Aniket on 6/19/16.
  *
  */


class DBController @Inject()(val reactiveMongoApi: ReactiveMongoApi)(implicit exec: ExecutionContext) extends Controller with MongoController with ReactiveMongoComponents{



  def apkfilesFuture: Future[JSONCollection] = database.map(_.collection[JSONCollection]("apkfiles"))
  /* def collection: JSONCollection = db.collection[JSONCollection]("apkfiles") **/


  def create(hashnumber: String, apklocation: String, appname: String, packagename: String, devname: String, price: String, uploaddate: String, size: String, noofdownloads: String, crawldate: String) = Action.async {

   /** val json = Json.obj(
      "hashnumber" -> hashnumber,
      "apk" -> apk,
      "created" -> new java.util.Date().getTime())

    collection.insert(json).map(lastError =>
      Ok("Mongo LastError: %s".format(lastError)))
     */
    println( "%%%%%%%%%%%%%%%%%%%%% Now I am in DB Create " )


    for {
      apkfile <- apkfilesFuture
      lastError <- apkfile.insert(APKfileinfo(hashnumber , apklocation , appname , packagename , devname , price , uploaddate , size , noofdownloads , crawldate))
    } yield
      Ok("Mongo LastError: %s".format(lastError))
  }

  def createFromJson = Action.async(parse.json) { request =>
    Json.fromJson[APKfileinfo](request.body) match {
      case JsSuccess(apkfiles, _) =>
        for {
          apkfile <- apkfilesFuture
          lastError <- apkfile.insert(apkfiles)
        } yield {
          Logger.debug(s"Successfully inserted with LastError: $lastError")
          Created("Created 1 ApkInfo")
        }
      case JsError(errors) =>
        Future.successful(BadRequest("Could not build a apkfile from the json provided. " + Errors.show(errors)))
    }
  }



  def createBulkFromJson = Action.async(parse.json) { request =>
    Json.fromJson[Seq[APKfileinfo]](request.body) match {
      case JsSuccess(newApkfile, _) =>
        apkfilesFuture.flatMap { apkfile =>
          val documents = newApkfile.map(implicitly[apkfile.ImplicitlyDocumentProducer](_))

          apkfile.bulkInsert(ordered = true)(documents: _*).map { multiResult =>
            Logger.debug(s"Successfully inserted with multiResult: $multiResult")
            Created(s"Created ${multiResult.n} cities")
          }
        }
      case JsError(errors) =>
        Future.successful(BadRequest("Could not build a apkfile from the json provided. " + Errors.show(errors)))
    }
  }

  def findByName(hashnumber: String) = Action.async {
    // let's do our query
    println( "%%%%%%%%%%%%%%%%%%%%% Now I am in DB find " )

    val futureApksList: Future[List[APKfileinfo]] = apkfilesFuture.flatMap {
      // find all apks with hashnumber `hashnumber`
      _.find(Json.obj("hashnumber" -> hashnumber)).
        // perform the query and get a cursor of JsObject
        cursor[APKfileinfo](ReadPreference.primary).
        // Collect the results as a list
        collect[List]()
    }

    // everything's ok! Let's reply with a JsValue
    futureApksList.map { apkfile =>
      Ok(Json.toJson(apkfile))
    }
  }

  def findrecords(hashidlist: List[String] ) = Action.async {



    val futureCitiesList: Future[List[APKfileinfo]] = apkfilesFuture.flatMap {
      // find all apks with hashnumber `hashnumber`
      _.find(Json.obj("hashnumber" -> hashidlist)).
        // perform the query and get a cursor of JsObject
        cursor[APKfileinfo](ReadPreference.primary).
        // Collect the results as a list
        collect[List]()
    }

    // everything's ok! Let's reply with a JsValue
    futureCitiesList.map { apkfile =>
      Ok(Json.toJson(apkfile))
    }
  }



}
