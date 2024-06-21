import com.android.build.gradle.tasks.SourceJarTask
import com.gradleup.librarian.core.librarianModule

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.plugin.compose")
}

librarianModule()

android {
  namespace = "com.apollographql.compose"
  compileSdk = 34

  defaultConfig {
    minSdk = 21
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    multiDexEnabled = true
  }

  testOptions.targetSdk = 30

  buildFeatures {
    compose = true
  }
}

dependencies {
  api(libs.compose.runtime)
  api(libs.apollo.runtime)
  api(libs.apollo.normalized.cache)
}

// TODO remove when https://github.com/GradleUp/librarian/pull/21 is merged
extensions.getByType(PublishingExtension::class.java).apply {
  publications.register("default", MavenPublication::class.java) {
    afterEvaluate {
      this@register.from(components.getByName("release"))
    }
  }
}
tasks.withType(SourceJarTask::class.java) {
  dependsOn("librarianGenerateVersion")
}
