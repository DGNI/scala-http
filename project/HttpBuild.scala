import sbt._
import Keys._

object Http extends Build {
  val defaultSettings = Seq(
  )

  lazy val root = Project(id = "http"
    , base = file(".")
    , settings = Project.defaultSettings ++ defaultSettings
  ) aggregate(common, server, client)

  lazy val common = Project(id = "http-common"
    , base = file("http-common")
    , settings = Project.defaultSettings ++ defaultSettings
  )

  lazy val server = Project(id = "http-server"
    , base = file("http-server")
    , settings = Project.defaultSettings ++ defaultSettings
  ) dependsOn(common)

  lazy val client = Project(id = "http-client"
    , base = file("http-client")
    , settings = Project.defaultSettings ++ defaultSettings
  ) dependsOn(common)
}
