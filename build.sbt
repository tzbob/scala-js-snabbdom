enablePlugins(ScalaJSBundlerPlugin)

resolvers += Resolver.bintrayRepo("webjars", "maven")
resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/snapshots"

organization in ThisBuild := "be.tzbob"
ThisBuild / scalaVersion := "2.13.1"

scalacOptions in ThisBuild ++= Seq(
  "-encoding",
  "UTF-8",
  "-feature",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
)

homepage := Some(url("https://github.com/tzbob/scala-js-snabbdom"))
licenses := Seq("MIT" -> url("https://opensource.org/licenses/mit-license.php"))
publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
pomExtra :=
  <scm>
    <url>git@github.com:tzbob/scala-js-snabbdom.git</url>
    <connection>scm:git:git@github.com:tzbob/scala-js-snabbdom.git</connection>
  </scm>
    <developers>
      <developer>
        <id>tzbob</id>
        <name>Bob Reynders</name>
        <url>https://github.com/tzbob</url>
      </developer>
    </developers>

version := "0.5.0"

name := "scala-js-snabbdom"

requireJsDomEnv in Test := true

libraryDependencies ++= Seq(
  "org.scala-js"  %%% "scalajs-dom" % "1.0.0",
  "org.scalatest" %%% "scalatest"   % "3.1.0" % Test,
)

npmDependencies in Compile += "snabbdom" -> "0.7.1"
