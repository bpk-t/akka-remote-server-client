
lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.12.6",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.12",
    "com.typesafe.akka" %% "akka-remote" % "2.5.12"
  ),
  fork in run := true
)

lazy val server = (project in file("server"))
  .settings(
    commonSettings
  )
  .settings(
    assemblyJarName in assembly := "server.jar"
  )

lazy val client = (project in file("client"))
  .settings(
    commonSettings
  )
  .settings(
    assemblyJarName in assembly := "client.jar",
  )

lazy val root = (project in file("."))
  .aggregate(server, client)

