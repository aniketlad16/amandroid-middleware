name := """amandroid-middleware"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.roundeights" %% "hasher" % "1.2.0",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.11.13",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test

)
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.2"
libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"
// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.3.1"


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers ++= Seq("RoundEights" at "http://maven.spikemark.net/roundeights")
