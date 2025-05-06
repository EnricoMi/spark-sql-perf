// Your sbt build file. Guides on how to write one can be found at
// http://www.scala-sbt.org/0.13/docs/index.html

name := "spark-sql-perf"

organization := "com.databricks"

scalaVersion := "2.12.18"

crossScalaVersions := Seq("2.12.18")

val sparkPackageName = "databricks/spark-sql-perf"

// All Spark Packages need a license
licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

val sparkVersion = "3.5.4"

initialCommands in console :=
  """
    |import org.apache.spark.sql._
    |import org.apache.spark.sql.functions._
    |import org.apache.spark.sql.types._
    |import org.apache.spark.sql.hive.test.TestHive
    |import TestHive.implicits
    |import TestHive.sql
    |
    |val sqlContext = TestHive
    |import sqlContext.implicits._
  """.stripMargin

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided",
  "com.github.scopt" %% "scopt" % "3.7.1",
  "com.twitter" %% "util-jvm" % "6.45.0" % "provided",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.yaml" % "snakeyaml" % "1.23",
)

fork := true

