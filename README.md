# Table of Contents
- [Datafy-Kotlin-Android-App](#datafy-kotlin-android-app)
- [Tech Stack](#tech-stack)
- [Why Kotlin?](#kotlin)
- [Why an Android app?](#android-app-motivation)

# Datafy-Kotlin-Android-App
Android application written in Kotlin for the Datafy project. For now, it offers the functionality of working with blogs, including the following actions:
- Edit
- Publish

# Tech Stack
- Live Data with View Model: I have adhered to using the recommended architecture endorsed by Android, thus I have defined view models for my data, and fetched them using coroutines.
- Coroutines: Used to fetch the blogs data without blocking the main thread. Currently, it may seem an overkill for the small amounts of blogs, but in time it will play a significant role in providing scalability, availability and performance.
- Retrofit: Used to make the RESTful calls to the [Datafy](https://github.com/DavidBuzatu-Marian/Datafy/) REST API.
- Hilt: Used as a dependency injection tool. Having used Spring Boot in my internship, I've looked for similar alternatives in the Android eco-system.
- Gradle: Used to handle dependencies.

# Kotlin
I have decided to use Kotlin due to its current demand, boiler-less code, fresh and easy syntax and out-of-the-box capabilities.
Learning Kotlin was for a long time on my learning list and this project seemed the right place to start using it.

Moreover, in my recent internship at **American Express**, I have encoutnered the need of a functionality offered by Kotlin's co-routines and I wanted to learn them as soon as possible.

# Android app motivation
Whenever I travel around the city, I don't carry my laptop around or at least it is quite inconvenient to use it in public spaces. I prefer taking out my phone and updating a blog than using my Laptop to perform RESTful calls.
