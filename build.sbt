name := """afpca"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "commons-validator" % "commons-validator" % "1.4.0",
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "com.typesafe.slick" %% "slick-codegen" % "3.0.0",
  "com.typesafe.slick" %% "slick-extensions" % "3.0.0",
  "org.slf4j" % "slf4j-nop" % "1.7.12",
  "com.typesafe.play" %% "play-slick" % "1.0.1",
  "mysql" % "mysql-connector-java" % "5.1.30"
)

//resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
