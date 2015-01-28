name := "ValidationDemo"

version := "0.1"

organization := "com.github.limansky"

scalaVersion := "2.11.5"

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)

libraryDependencies ++= {
  val liftVersion = "2.6"
  Seq(
    "net.liftweb"         %% "lift-webkit"              % liftVersion % "compile",
    "net.liftmodules"     %% "lift-jquery-module_2.6"   % "2.8",
    "net.liftmodules"     %% "validate_2.6"             % "1.0-SNAPSHOT",
    "ch.qos.logback"      %  "logback-classic"          % "1.1.2"
  )
}

jetty()
