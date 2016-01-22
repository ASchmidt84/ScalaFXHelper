name := "ScalaFXHelper"

version := "1.0"

scalaVersion := "2.11.7"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.2.2"
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.60-R9"