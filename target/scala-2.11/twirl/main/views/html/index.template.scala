
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template takes a single argument, a String containing a
* message to display.
*/
  def apply/*5.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.19*/("""

"""),format.raw/*7.1*/("""<html lang="en">
<head>
 <title>Home</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <div class="jumbotron">
  <h1>Amandroid Middleware</h1>
  <p><a href="/">Research Console</a></p>
 </div>

</div>

<div class="container">
 <div class="row">
  <div class="col-md-6">
   <div class="panel panel-default">
    <div class="panel-heading">Result Panel</div>
    <div class="panel-body">"""),_display_(/*31.30*/message),format.raw/*31.37*/("""</div>
   </div>
  </div>
  <div class="col-md-6">

   <ul class="nav nav-tabs nav-pills" role="tablist">
    <li class="active"><a data-toggle="tab" href="#home">Crawl Google Play</a></li>
    <li><a data-toggle="tab" href="#menu1">Query Database</a></li>
       <li><a data-toggle="tab" href="#menu2">Auto Crawl</a></li>
       <li><a data-toggle="tab" href="#menu3">App Analysis</a></li>

   </ul>

   <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
     <h3>Crawl Google Play &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" >Config</button> </h3>
        <br>
     <form role="form"  action="/result" method="post" enctype="multipart/form-data">
      <div class="form-group">
       <label>App Name:</label>
       <input type="text" class="form-control" id="app" name="app" placeholder="Enter app name" required>
       <br>
       <label>Operation:</label>
       <select  class="form-control" id = "appOperation" name = "appOperation"  required>
        <option>search</option>
        <option>download</option>
        <option>categories</option>
        <option>list</option>
        <option>permissions</option>
        <option>reviews</option>
        <option>recommendations</option>
        <option>register</option>
       </select>
       <br>

      </div>
      <button type="submit" class="btn btn-default">Submit</button>
     </form>



        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Crawler Configuration</h4>
                    </div>
                    <div class="modal-body">

                        <form role="form" method="post" action="/configSetup" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Login UserID</label>
                                <input type="text" class="form-control" id="userId" name="userId" placeholder="User name" required>
                                <br>
                                <label>Password</label>
                                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password" required>
                                <br>
                                <label>Android DeviceId</label>
                                <input type="text" class="form-control" id="deviceId" name="deviceId" placeholder="Android Device Id" required>
                                <br>

                            </div>
                            <div class="modal-footer">
                            <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                        </form>


                    </div>


                </div>

            </div>

            </div>


    </div>
    <div id="menu1" class="tab-pane fade">
     <h3>Query Database</h3>
        <br>
     <div class="form-group">
      <label>Query:</label>
      <input type="text" class="form-control" id="query" name="query" placeholder="Enter Query" required>

      <br>

     </div>
     <button type="submit" class="btn btn-default">Submit</button>
    </div>

       <div id="menu2" class="tab-pane fade">



           <ul class="nav navbar-nav in submenu" role="navigation" style="background-color:#e6f2ff;">
               <li class="active" ><a data-toggle="tab" href="#submenu1" >Upload file and Crawl</a></li>
               <li ><a data-toggle="tab" href="#submenu2"  >Auto Search and Crawl<span class="badge" >42</span></a></li>

           </ul>

           <div class="tab-content">
               <br>
               <br>
               <div id="submenu1" class="tab-pane fade in active">
                   <h3>File Upload</h3>

                   <form role="form" action="/fileUpload" method="post" enctype="multipart/form-data">

                       <div class="form-group">
                           <input class="form-control" type="text" placeholder="File Upload:" readonly>
                           <label></label>
                           <br>
                           <br>

                           <label class="file">
                               <input type="file" id="file" name="uploadedfile">
                               <span class="file-custom"></span>
                           </label>
                           <br>

                       </div>
                       <button type="submit" value='Show Layer' class="btn btn-default" onclick=""> Upload file and start</button>
                   </form>
                   <br>
                   <br>

                   <div class="progress" id="sub3">
                       <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                           """),_display_(/*165.29*/message),format.raw/*165.36*/("""
                       """),format.raw/*166.24*/("""</div>
                   </div>

               </div>

               <div id="submenu2" class="tab-pane fade">

                   <h3>Start Crawl Without Upload</h3>

                   <form role="form" action="" method="post" enctype="multipart/form-data">

                       <input class="form-control" type="text" placeholder="Start Crawl:" readonly>
                       <br>
                       <br>
                       <button type="submit" value='Show Layer' class="btn btn-default" onclick="">Start Crawl</button>
                   </form>
               </div>




           </div>


       </div>

       <div id="menu3" class="tab-pane fade">
           <h3>Analysis by Amandroid</h3>
           <br>
           <div class="form-group">
               <label>Database:</label>

               <br>

           </div>
           <button type="submit" class="btn btn-default">Submit</button>
       </div>

   </div>



  </div>
 </div>
</div>




</body>
</html>"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/*
* This template takes a single argument, a String containing a
* message to display.
*/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sun Jun 26 21:45:45 EDT 2016
                  SOURCE: /Users/Aniket/Documents/activator-1.3.10-minimal/bin/amandroid-middleware/app/views/index.scala.html
                  HASH: 9cde10457044da36fab088f49e9aa85d4e162b0a
                  MATRIX: 613->92|725->109|753->111|1543->874|1571->881|6915->6197|6944->6204|6997->6228
                  LINES: 23->5|28->5|30->7|54->31|54->31|188->165|188->165|189->166
                  -- GENERATED --
              */
          