import sbt.Defaults.sbtPluginExtra

// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
//libraryDependencies += sbtPluginExtra(
//  TypesafeLibrary.playSbtPlugin.value,
//  (sbtBinaryVersion in update).value,
//  (scalaBinaryVersion in update).value
//)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.3")
//addSbtPlugin("com.typesafe.sbt" % "sbt-bundle" % "1.3.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.10")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")
addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.2")
//addSbtPlugin("com.typesafe.sbt" % "sbt-bintray-bundle" % "1.2.0")

addSbtPlugin("com.lightbend.conductr" % "sbt-conductr" % "2.7.2")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")
