package controllers

import java.io.{File, FileReader, _}
import java.util
import java.util.ArrayList

import akka.util.ByteString
import com.akdeniz.googleplaycrawler.cli.googleplay
import com.google.gson._
import com.roundeights.hasher.Implicits._
import customUtil.DictionarySerialize
import org.apache.commons.io.{FileUtils, LineIterator}
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import play.api.mvc._
import models.APKfileinfo
import play.api.http.HttpEntity

import scala.collection.JavaConversions._
import scala.language.postfixOps
import scala.util.control.Breaks._
import org.apache.http.client.methods.HttpGet
import org.apache.http.util.EntityUtils



/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
class HomeController extends Controller {

  var applicationName = ""
  var appOp = ""
  var userIDStr = "faltumail16"
  var pwdStr = "faltumail"
  var deviceIdStr = "3b072f299be849e6"
  val googleobj = new googleplay(deviceIdStr, userIDStr+"@gmail.com", pwdStr)


  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */


  def index = Action {

    Ok(views.html.index("Welcome to Amandroid Crawler!"))
  }


  def result = Action(parse.multipartFormData) { request =>

    val appName = request.body.dataParts.get("app").get
    val operation = request.body.dataParts.get("appOperation").get

    for(elem <- appName) {
      applicationName = elem
    }

    for(elem1 <- operation) {
      appOp = elem1
    }

    print(applicationName+"   "+appOp)

    Redirect("/crawl/" + applicationName)

  }

  def crawl(applicationName: String) = Action {



    try {


      // using the Runtime exec method:

      if (userIDStr == "" && pwdStr == "" && deviceIdStr == "") {
        userIDStr = "faltumail16"
        pwdStr = "faltumail"
        deviceIdStr = "3b072f299be849e6"
      }

      var formatted =  new java.util.ArrayList[String]()
      var searchpackages =  List[String]()



      appOp match {
        case "checkin" =>  googleobj.checkinCommand()

        case "download" =>

          searchpackages ::= applicationName

          var file = new java.util.ArrayList[File]()
          file = googleobj.downloadCommand(searchpackages)
        //file.get(0).createNewFile();

        case "list" => jsongetbulk()

        // googleobj.listCommand()

        case "categories" => googleobj.categoriesCommand()

        case "search" =>

          formatted = googleobj.searchCommand(applicationName)
          println("---------Size of Search: "+formatted.size())
          //var temp =  new ArrayList[String]()



          formatted.foreach {

            i =>


              val l =  i.split(";").length
              var tupples = new Array[String](l)
              tupples = i.split(";")
              searchpackages::= tupples(1)
              println(tupples(0) + ","+ tupples(1)+ ","+ tupples(2)+ ","+ tupples(3)+ ","+ tupples(4)+ ","+ tupples(5)+","+tupples(6))


          }



        case "permissions" => googleobj.permissionsCommand()

        case "reviews" => googleobj.reviewsCommand()

        case "register" => googleobj.registerCommand()

        case "usegcm" => googleobj.useGCMCommand()

        case "recommendations" => googleobj.recommendationsCommand()
      }


      //val jsonObj = " ".parseJson


    }
    catch {
      case ioe: IOException =>
      println("exception happened - here's what I know: "+ ioe.printStackTrace())

    }


    Ok(views.html.index(" "))
  }

  def fileUpload = Action(parse.multipartFormData) { request =>
    request.body.file("uploadedfile").map { uploadedfile =>
      import java.io.File
      val filename = uploadedfile.filename
      val contentType = uploadedfile.contentType
      uploadedfile.ref.moveTo(new File("/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/ResourceFiles/uploadedfile.txt"))
      autoCrawl(2)
      Ok(views.html.index("File uploaded"))

    }.getOrElse {
      Redirect(routes.HomeController.index()).flashing(
        "error" -> "Missing file")
      Ok(views.html.index("File couldn't be uploaded!"))
    }


  }

  def autoCrawl (userOpt: Int) {


    try {

      if (userIDStr == "" && pwdStr == "" && deviceIdStr == "") {
        userIDStr = "faltumail16"
        pwdStr = "faltumail"
        deviceIdStr = "3b072f299be849e6"
      }

      if(userOpt == 1) {
        val uploadedfile = new File("/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/ResourceFiles/uploadedfile.txt")

        val it = FileUtils.lineIterator(uploadedfile, "UTF-8")
        var autocpackages = List[String]()

        while (it.hasNext()) {
          autocpackages ::= it.nextLine()
        }

        LineIterator.closeQuietly(it)
        googleobj.downloadCommand(autocpackages)
      } else{

        val obj = new DictionarySerialize()
        val dictWords = new util.ArrayList[String]()

        val br = new BufferedReader(new FileReader("/Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/ResourceFiles/dictionary.txt"))
        var line = " "
        while (br.readLine()!= null) {
          line = br.readLine()
          dictWords.add(line)
        }
        val interruptVar = false



        for (i <- obj.deserializableMethod() to dictWords.size()) {
          breakable {
            var searchpackages =  List[String]()
            var formatted =  new ArrayList[String]()
            var md5list =  new java.util.ArrayList[String]()

            val apkinfo = new Array[APKfileinfo](50)

            System.out.println(dictWords.get(i))

            try{
              formatted = googleobj.searchCommand(dictWords.get(i))

            } catch {

              case ioe: IndexOutOfBoundsException =>
                println("exception happened - here's what I know: "+ ioe.printStackTrace())
                break()
            }

            var temp =  new util.ArrayList[String]()
            val crawldate = new java.util.Date()
            var it = 0
            formatted.foreach {

              x =>


                val l =  x.split(";").length
                var tupples = new Array[String](l)
                tupples = x.split(";")
                searchpackages::= tupples(1)
                apkinfo(it)=new APKfileinfo("md5","/downloadedApks/"+tupples(1)+".apk",tupples(0),tupples(1),tupples(2),tupples(3),tupples(4),tupples(5),tupples(6), crawldate.toString)
                println(tupples(1))
                it = it+1
            }

            jsonpost(apkinfo)

            var file = new java.util.ArrayList[File]()
            file = googleobj.downloadCommand(searchpackages.drop(47))

            //file.get(0).createNewFile();
            // convert it to a JSON string

            /* hashingMethod(scala.io.Source.fromFile(file.get(it)))
            formatted.foreach {

              x =>


                val l =  x.split(";").length
                var tupples = new Array[String](l)
                tupples = x.split(";")
                it = it +1
            }*/



            if (interruptVar) {
              // call serializable and store value of i
              obj.serializeMethod(i)
              break()

            }
          }
        }

      }

    }
    catch {
      case ioe: IOException =>
        println("exception happened - here's what I know: "+ ioe.printStackTrace())

    }

  }

  def configSetup = Action(parse.multipartFormData) { request =>

    val userId = request.body.dataParts.get("userId").get
    val pwd = request.body.dataParts.get("pwd").get
    val deviceId = request.body.dataParts.get("deviceId").get



    for(elem <- userId) {
      userIDStr = elem
    }

    for(elem1 <- pwd) {
      pwdStr = elem1
    }

    for(elem2 <- deviceId) {
      deviceIdStr = elem2
    }

    var starCreat = pwdStr.length

    var star = ""

    while(starCreat != 0){
      star = star + "*"
      starCreat = starCreat - 1
    }

    Ok(views.html.index("Configuration Changed! NEW:"+ userIDStr+", "+star+", "+deviceIdStr))
  }

  def hashingMethod (sourceApk: scala.io.Source ): String = {

    val source = sourceApk


    //scala.io.Source.fromFile("/Users/Aniket/Desktop/result.txt")

    val lines = try source.getLines mkString "\n" finally source.close()

    val hashMe = lines

    // Generate a few hashes
    val md5 = hashMe.md5
    // Print each hex encoded hash

    println( "==========================MD5: " + md5.hex )

    // Compare the original value to each hashed value
    // and print the boolean result
    //println("MD5 Matches: " + (hashMe.md5 hash= md5) )

    return md5.hex

  }

  def jsonpost(apkinfo: Array[APKfileinfo]) {

   // val apkinfo1:Array[APKfileinfo]=new Array[APKfileinfo](1)


    // convert it to a JSON string
    val stockAsJson = new Gson().toJson(apkinfo)

    // create an HttpPost object
    val post = new HttpPost("http://localhost:9000/apkfile/bulk")

    // set the Content-type
    post.setHeader("Content-type", "application/json")

    // add the JSON as a StringEntity
    post.setEntity(new StringEntity(stockAsJson))

    // send the post request
    val response = (new DefaultHttpClient).execute(post)

    // print the response headers
    println("--- HEADERS ---")
    response.getAllHeaders.foreach(arg => println(arg))
  }

  def jsonget(hashno: String) {
    val post = new HttpGet("http://localhost:9000/apkfile?hashnumber="+ hashno)
    post.setHeader("Content-type", "application/json")


    val response = (new DefaultHttpClient).execute(post)
    println("--- HEADERS ---")
    val jsonvar = EntityUtils.toString(response.getEntity())

    println("HIiiiiiiii: "+jsonvar)
  }

  def jsongetbulk() {
    var listvar = List[String]()
    listvar ::= "md5"
    val post = new HttpGet("http://localhost:9000/apkfile/find?hashidlist=md5,md5,md5")
    post.setHeader("Content-type", "application/json")

    val response = (new DefaultHttpClient).execute(post)
    println("--- HEADERS ---")
    val jsonvar = EntityUtils.toString(response.getEntity())

    println("HIiiiiiiii: "+jsonvar)
  }

}

