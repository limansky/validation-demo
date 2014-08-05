name := "ValidationDemo"

version := "0.1"

organization := "com.github.limansky"

scalaVersion := "2.11.2"

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)

seq(webSettings :_*)

libraryDependencies ++= {
  val liftVersion = "2.6-RC1"
  Seq(
    "net.liftweb"         %% "lift-webkit"              % liftVersion % "compile",
    "net.liftmodules"     %% "lift-jquery-module_2.6"   % "2.8",
    "net.liftmodules"     %% "validate_2.6"             % "1.0-SNAPSHOT",
    "ch.qos.logback"      %  "logback-classic"          % "1.1.2",
    "org.eclipse.jetty"   %  "jetty-webapp"             % "9.2.2.v20140723" % "container",
    "org.eclipse.jetty"   %  "jetty-jsp"                % "9.2.2.v20140723" % "container"
  )
}
