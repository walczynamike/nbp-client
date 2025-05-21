import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
}

group = "io.github.walczynamike"
version = "0.0.1"

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlin.datetime)
            implementation(libs.kotlin.serialization)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging.jvm)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.kotlinx.coroutines.core)

        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.android)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.ktor.client.mock)
            implementation(libs.kotlinx.coroutines.test)
        }
    }
}

android {
    namespace = "io.github.walczynamike.nbp"
    compileSdk = 36
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    if (System.getenv("CI") == "true") {
        signAllPublications()
    }

    coordinates(
        groupId = group.toString(),
        artifactId = "nbp-client",
        version = version.toString()
    )
    // sample POM
    pom {
        name = "Nbp Client"
        description =
            "Kotlin Multiplatform client for fetching exchange rates and gold prices from the official NBP API"
        inceptionYear = "2025"
        url = "https://github.com/walczynamike/nbp-client"
        licenses {
            license {
                name = "Apache License 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0"
            }
        }
        developers {
            developer {
                id = "walczynamike"
                name = "Michal Walczyna"
                url = "https://github.com/walczynamike"
                email = "33330036+walczynamike@users.noreply.github.com"
            }
        }
        scm {
            url = "https://github.com/walczynamike/nbp-client"
            connection = "scm:git:https://github.com/walczynamike/nbp-client.git"
            developerConnection = "scm:git:ssh://git@github.com/walczynamike/nbp-client.git"
        }
    }
}
