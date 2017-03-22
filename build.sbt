enablePlugins(ScalaJSBundlerPlugin)

resolvers += Resolver.bintrayRepo("webjars", "maven")
resolvers += "Sonatype OSS Snapshots" at
"https://oss.sonatype.org/content/repositories/snapshots"

organization in ThisBuild := "be.tzbob"
scalaVersion in ThisBuild := "2.12.1"
crossScalaVersions in ThisBuild := Seq("2.11.8", "2.12.1")

scalacOptions in ThisBuild ++= Seq(
  "-encoding",
  "UTF-8",
  "-feature",
  "-deprecation",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)

version := "0.1.0-SNAPSHOT"

name := "scala-js-snabbdom"

requiresDOM := true

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
)
npmDependencies in Compile += "snabbdom" -> "0.5.4"
