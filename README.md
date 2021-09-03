# Datafy-Kotlin-Android-App
Android application written in Kotlin for the Datafy project. For now, it offers the functionality of working with blogs, including the following actions:
- Edit the blogs

The application has been created to offer an intuitive and easy UI to edit and publish blogs anywhere.

**Disclaimer**:
The docker image being employed in the **EC2** instance is currently having some issues with GitHub credentials, thus saving an edit for blogs will raise a 500 error code.

# Table of Contents
- [Getting Started](#getting-started)
- [Screenshots](#screenshots)
- [Tech Stack](#tech-stack)
- [Why Kotlin?](#kotlin)
- [Why an Android app?](#android-app-motivation)

# Getting Started
This project uses the Gradle build system. Preferably, one can use the `Import Project` functionality from Android Studio to import the project.
Once opened, the app can be either run on an Android Simulated device (**have not tested this**) or by plugging in an Android device via a USB/USB-C cable and by clicking the `Run` button in Android Studio.

# Screenshots
| <img src="https://i.ibb.co/8K6wC70/ed58996c-afef-47cf-972a-be5fe21fb019.jpg" alt="ed58996c-afef-47cf-972a-be5fe21fb019" border="0" /> | <img src="https://i.ibb.co/BwkCtVH/Whats-App-Image-2021-09-03-at-20-13-35.jpg" alt="Whats-App-Image-2021-09-03-at-20-13-35" border="0" /> |
| ----------- | ----------- |

# Tech Stack
- Architecture: I have built this application following Google's guidelines on [Android applications architecture](https://developer.android.com/jetpack/arch/)
- [View Model(s)](https://developer.android.com/topic/libraries/architecture/viewmodel): I have used ViewModel to build objects that are persistent through an Activity's lifecycle and that provides an easy way to perform data updates asynchronously, 'far' from the views.
- [Live Data](https://developer.android.com/topic/libraries/architecture/livedata): I have used LiveData to build view models that will enable views to receive changes as soon as they occur.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html): Used to fetch the blogs data without blocking the main thread. Currently, it may seem an overkill for the small amounts of blogs, but in time it will play a significant role in providing scalability, availability and performance. Mooreover, coroutines are one of the many ingredients of Kotlin that make it a better choice compared to Java.
- [Retrofit](https://square.github.io/retrofit/): Used to make the RESTful calls to the [Datafy](https://github.com/DavidBuzatu-Marian/Datafy/) REST API.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android): Used as a dependency injection tool. Having used Spring Boot in my internship at American Express, I've looked for similar alternatives in the Android eco-system.
- [Gradle](https://gradle.org): Used to handle dependencies.
- [Markwon](https://github.com/noties/Markwon): I have used this external library to display markdown on the Android app.

# Kotlin
I have decided to use Kotlin due to its current demand, 'boiler-less' code, fresh and easy syntax and out-of-the-box capabilities.
Learning Kotlin was for a long time on my learning list and this project seemed the right place to start using it.

Moreover, in my recent internship at **American Express**, I have encoutnered the need of the functionality offered by Kotlin's coroutines and I've wanted to learn them as soon as possible.

# Android app motivation
Whenever I travel around the city, I don't carry my laptop around or at least it is quite inconvenient to use it in public spaces. I prefer taking out my phone and updating a blog than using my Laptop to perform RESTful calls.
