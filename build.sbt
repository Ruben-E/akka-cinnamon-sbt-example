// Enable the Lightbend Telemetry (Cinnamon) sbt plugin
lazy val app = project in file(".") enablePlugins (Cinnamon)

// Add the Cinnamon Agent for run and test
cinnamon in run := true
cinnamon in test := true

// Set the Cinnamon Agent log level
cinnamonLogLevel := "INFO"

name := "akka-cinnamon-sbt-example"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies += Cinnamon.library.cinnamonCHMetrics
libraryDependencies += Cinnamon.library.cinnamonCHMetricsJvmMetrics
libraryDependencies += Cinnamon.library.cinnamonCHMetricsStatsDReporter
libraryDependencies += Cinnamon.library.cinnamonAkka

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"