import com.gradleup.librarian.gradle.librarianRoot

plugins {
  id("org.jetbrains.kotlin.multiplatform").version("2.0.0").apply(false)
  id("org.jetbrains.kotlin.plugin.compose").version("2.0.0").apply(false)
  id("com.gradleup.librarian").version("0.0.4").apply(false)
  id("com.android.library").version("8.2.2").apply(false)
}

librarianRoot()
