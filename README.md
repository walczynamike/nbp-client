# nbp-client

**A Kotlin Multiplatform library for fetching exchange rates and gold prices from the official NBP (Narodowy Bank Polski) API.**

---

## 📦 Overview

This library provides a unified Kotlin API to retrieve data from the publicly available [NBP Web API](https://api.nbp.pl), including:

- 💱 **Exchange rate tables** (A, B, C)
- 🪙 **Gold prices**
- 📅 **Historical data** and daily updated exchange rates

Built with Kotlin Multiplatform (KMP), it works across:
- Android
- iOS

---

## ✨ Features

- ✅ Fetch current and historical exchange rates
- ✅ Support for table types A, B, and C
- ✅ Fetch daily gold prices
- ✅ Full multiplatform compatibility (KMP)
- ✅ Pluggable HTTP client and serialization
- ✅ Designed for simplicity and extensibility

---

## 🔧 Installation

### Gradle (Kotlin DSL)

In your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.walczynamike:nbp-client:<version>")
}
```
--- 

## 🔧 Publishing to Maven Local

During development, you can publish the library locally to test it in other projects without pushing to a remote repository like Maven Central.

### Step 1: Publish to Your Local Maven Repository

Run the following command from your library’s root directory:

```bash
./gradlew publishToMavenLocal --no-configuration-cache
```

This compiles and publishes your KMP library to your local Maven repository (by default: ~/.m2/repository), using a Maven-compatible structure.

On macOS or Linux, the .m2 directory is typically located at: 
```
/Users/<your-username>/.m2/repository/com/walczynamike/nbp-client/<library-version>>/
```

### Step 2: Consuming the Locally Published Library on Android

To test the library in another project (e.g. a sample app), configure the project to look in your local Maven repository.

#### 1. Add `mavenLocal()` to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal() // Enables resolution from local Maven repo
    }
}
```

#### 2. Add the dependency in your module’s `build.gradle.kts`:
```kotlin
dependencies {
    implementation("com.walczynamike:nbp-client:0.0.1")
}
```

#### 3. Sync or build the project — Gradle will resolve the dependency from your ~/.m2/repository directory without needing a remote publish.
