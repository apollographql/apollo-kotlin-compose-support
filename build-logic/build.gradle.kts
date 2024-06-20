plugins {
  `embedded-kotlin`
}

dependencies {
  implementation(libs.kgp)
  implementation(libs.librarian)
  implementation(libs.android.plugin)
  implementation(libs.kotlin.plugin.compose)
}

group = "build-logic"
