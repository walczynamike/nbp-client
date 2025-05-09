# nbp-client

**A Kotlin Multiplatform library for fetching exchange rates and gold prices from the official NBP (Narodowy Bank Polski) API.**

---

## 📦 Overview

This library provides a unified Kotlin API to retrieve data from the publicly available [NBP Web API](https://api.nbp.pl), including:

- 💱 **Exchange rate tables** (A, B, C)
- 🪙 **Gold prices**
- 📅 **Historical data** and daily updated exchange rates
- 🔁 JSON and XML format support

Built with Kotlin Multiplatform (KMP), it works across:
- Android
- iOS
- JVM
- JavaScript (browser/Node)

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