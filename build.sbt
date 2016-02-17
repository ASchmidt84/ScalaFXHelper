name := "ScalaFXHelper"

version := "1.1"

scalaVersion := "2.11.7"

organization := "de.intelligyscience"

organizationName := "Intelligy Science UG (haftungsbeschränkt)"

scalaVersion := "2.11.7"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.2.2"
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.60-R9"
libraryDependencies += "org.controlsfx" % "controlsfx" % "8.40.10"

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

homepage := Some(url("https://github.com/IntelligyScience/PlayPayPalIntegration"))

scmInfo := Some(ScmInfo(
  url("https://github.com/IntelligyScience/ScalaFXHelper"),
  "scm:git:https://github.com/IntelligyScience/ScalaFXHelper.git",
  Some("scm:git:git@github.com:IntelligyScience/ScalaFXHelper.git")
))

credentials += Credentials(Path.userHome / ".sbt" / ".isCredentials")

publishTo := {
  val nexus = "http://46.4.103.179:8888/nexus/content/repositories/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "snapshots/")
  else
    Some("releases"  at nexus + "releases/")
}