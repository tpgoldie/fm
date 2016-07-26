name := "Financial Markets"

scalaVersion := "2.11.8"

val jodatime = "joda-time" % "joda-time" % "2.9.4"

val jodamoney = "org.joda" % "joda-money" % "0.11"

val jodaconvert = "org.joda" % "joda-convert" % "1.8.1"

val scalatest = "org.scalatest" % "scalatest_2.11" % "3.0.0-M16-SNAP6"

libraryDependencies ++= Seq(
  jodatime, jodamoney, jodaconvert, scalatest
)
