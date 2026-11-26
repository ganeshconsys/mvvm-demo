# MVVM Android Demo

A small Android app that fetches mock posts from [JSONPlaceholder](https://jsonplaceholder.typicode.com/posts) and displays their titles in a scrollable Jetpack Compose list. The screen shows a loading indicator during the request and a retry button if it fails.

## How it works

- `data` defines the post model and Retrofit API interface.
- `repository` configures Retrofit and fetches the posts.
- `viewmodel` manages the posts, loading flag, and error message.
- `ui` renders the list with Compose.

## Run locally

Open the project in Android Studio with Android SDK 37 installed. Select an emulator or connected Android device and click **Run**. The app needs an internet connection to load posts.

To build a debug APK on Windows, run:

```powershell
.\gradlew.bat :app:assembleDebug
```
