name := "CassandraStore"

version := "0.1"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe repository releases"  at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype repo"                 at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"             at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"            at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"              at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository"    at "http://download.java.net/maven/2/",
  "Twitter Repository"            at "http://maven.twttr.com",
  Resolver.bintrayRepo("websudos", "oss-releases")
)

scalacOptions ++= Seq(
  "-Xlint",
  "-deprecation",
  "-feature",
  "-unchecked"
)

libraryDependencies ++= {
  val akkaVerion = "2.4.12"
  Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % "test" ,
    "com.websudos" %% "phantom-dsl" % "1.29.4"
    //"com.chrisomeara" % "pillar_2.11" % "2.3.0"
  )
}
