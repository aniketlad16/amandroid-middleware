# Amandroid Crawler-middleware
Aniket's GradProject at BGSU

Details about Amandroid-Crawler-middleware application
======================================================

This file will be packaged with application when using `activator dist`.

downloadedApks
==============

This is the folder where the apks downloaded directly from google play store by this crawler will be stored.

gPlayAPI
========

This is a python package inside this scala based project. this is the brain of this application contains protocol source code file googleplay.proto to conncet with the google server and methods like login, search, download etc. in googleplay.py file are used to perform various apk crawling functions. It also has separate .py files for download, search etc functions to provide parameters or any manupulation required before request pass to the main googleplay.py class. It is compiled runtime with the help of jython - a jar file which is used to run and access pyhon scripts from Java/Scala.

lib
====

This folder contains the external jar file required jython.jar

pkgNameFiles
============

This is the folder which stores the text file uploaded by user contains apk files names for auto download (crawling). The same file be read by autodownload.py file to continuously read the package name and download it.


Controllers
===========

- HomeController.scala:

  Shows how to handle simple HTTP requests.
  All the logic funciton are located in this controller only.

- AsyncController.scala:

  Shows how to do asynchronous programming when handling a request.

- CountController.scala:

  Shows how to inject a component into a controller and use the component when
  handling requests.

Components
==========

- Module.scala:

  Shows how to use Guice to bind all the components needed by your application.

- Counter.scala:

  An example of a component that contains state, in this case a simple counter.

- ApplicationTimer.scala:

  An example of a component that starts when the application starts and stops
  when the application stops.

Filters
=======

- Filters.scala:

  Creates the list of HTTP filters used by your application.

- ExampleFilter.scala

  A simple filter that adds a header to every response.
  
  ----------------------------------------------------------------
  
  Details about logic in important Files
  =======================================
  
  As only one file index.scala.html is used for the front view and it has all the forms and layout displayed on the browser. Later the front end will be moved to AngularJS and this application will be separately run and access by AngularJS front end through Webservices.
  
  The logic related to the view is placed in HomeController.scala file inside controllers folder. It has several functions which perfoms different actions based on users clicks from the front end.
  
  Details about important methods in HomeCotroller.scala
  ======================================================
  
  - index : It's first method which will call after launch of the applicaiton.
  - result : It will accept the data enter by user from the frontend tab Crawl google and redirect the values to crawl method.
  - crawl: It is the method which runs the python script file and passes the parameters to download the apks. In this method, calling python classes depeding on the operation user wants to perform.
  - fileUpload: Method used to handle the text file uploaded by the user and placed it inside the apporpriate folder.
  - autocrawl: Separate method to handle automatic crawl request from user.
  - configsetup: This is the method used to handle the configuration change request (Username,password, android id to be used for crawliing google paly). It set the respective global variables which will be used by the crawl and autocrawl methods to download the apk files from google play store.
  
  -----------------------------------------------------------------
  
  Platform Required
  ==================
  
  - Java 1.7 should be installed at the system where it will run.
  - Python 2.6+ should be installed at the system.
