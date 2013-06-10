import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "computer-database"
    val appVersion      = "1.0"
        
    val customResolvers = Seq(
        "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository",
  	    "fwbrasil.net" at "http://fwbrasil.net/maven/"
  	)
  	
    val activateVersion = "1.3"
  	val activateCore = "net.fwbrasil" %% "activate-core" % activateVersion
  	val activatePlay = "net.fwbrasil" %% "activate-play" % activateVersion
  	val activateJdbc = "net.fwbrasil" %% "activate-jdbc" % activateVersion
    val activateJdbcASync = "net.fwbrasil" %% "activate-jdbc-async" % activateVersion
    val activateMongoASync = "net.fwbrasil" %% "activate-mongo-async" % activateVersion

    val mysql = "mysql" % "mysql-connector-java" % "5.1.16"
    val postgresql = "postgresql" % "postgresql" % "9.1-901.jdbc4"

    val appDependencies = Seq(
    	jdbc,
    	anorm
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
        libraryDependencies ++= Seq(activateCore, activatePlay, activateJdbc, 
          activateJdbcASync, mysql, postgresql, activateMongoASync),
    	resolvers ++= customResolvers,
    	Keys.fork in Test := false
    )

}
            
