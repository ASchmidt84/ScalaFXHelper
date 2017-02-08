name := "ScalaFXHelper"

version := "1.13"

scalaVersion := "2.12.1"

crossScalaVersions := Seq("2.11.8","2.12.0")

organization := "de.scalamat"

organizationName := "Scalamat UG (haftungsbeschränkt)"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.102-R11"
libraryDependencies += "org.controlsfx" % "controlsfx" % "8.40.12"

publishTo := Some(
  if (version.value endsWith "-SNAPSHOT")
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

licenses += (("MIT", url("http://opensource.org/licenses/MIT")))
startYear := Some(2016)

pomExtra :=
  <developers>
    <developer>
      <id>IntelligyScience</id>
      <name>Andre Schmidt</name>
      <url>https://github.com/IntelligyScience</url>
    </developer>
  </developers>

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }

homepage := Some(url("https://github.com/IntelligyScience/ScalaFXHelper"))

scmInfo := Some(ScmInfo(
  url("https://github.com/IntelligyScience/ScalaFXHelper"),
  "scm:git:https://github.com/IntelligyScience/ScalaFXHelper.git",
  Some("scm:git:git@github.com:IntelligyScience/ScalaFXHelper.git")
))


publishTo := {
  val nexus = "http://nexus.intelligyscience.de/content/repositories/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "snapshots/")
  else
    Some("releases"  at nexus + "releases/")
}