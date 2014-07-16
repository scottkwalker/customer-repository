name := "customer-repository"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.0.1" % "test",
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.2"
)     

play.Project.playScalaSettings
