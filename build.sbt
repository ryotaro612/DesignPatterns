lazy val root = (project in file(".")).
  settings(
    name := "rss",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies += "com.rometools" % "rome" % "1.5.1"
  )


