# Arif Live TV — Android project + GitHub Actions build

This is a starter Android WebView wrapper around the Arif Live TV web prototype. It is **not** a finished production live-TV service.

## Build online with GitHub Actions (no Android Studio needed)

1. Sign in to GitHub and create a new **Public** or **Private** repository named `Arif-Live-TV`.
2. On the repository page choose **Add file → Upload files**.
3. Extract this ZIP on your computer, open the extracted `Arif_Live_TV_Android_Project` folder, select all files **inside that folder** (including the hidden `.github` folder), and upload them to the repository root.
4. Commit the upload to the `main` branch.
5. Open the repository's **Actions** tab. Select **Build Arif Live TV APK** on the left and click **Run workflow** if it has not started automatically.
6. Wait for the workflow to finish with a green check mark.
7. Open the completed workflow run, scroll to **Artifacts**, and download `Arif-Live-TV-debug-APK`. Extract the downloaded artifact ZIP to get `app-debug.apk`.
8. Copy `app-debug.apk` to your Android phone and install it. If Android asks, allow installation from that source.

The workflow uses Java 17, Gradle 8.9 and Android SDK 35. It creates a **debug/test APK**, not a Play Store release-signed APK.

## Build locally

Open this folder in Android Studio with Android SDK 35 installed, then build the `app` debug variant. The debug APK is written to `app/build/outputs/apk/debug/app-debug.apk`.

## Included

- Android app label: Arif Live TV
- Home UI, category filter and theme toggle
- Local admin prototype and player page
- GitHub Actions workflow to build and upload the debug APK

## Important limitations

- This is a starter prototype, not a completed production live TV app.
- The admin data is stored only in the app/browser local storage; it is not synced to a secure online database.
- A production admin panel needs a backend, authentication and database security rules.
- Add only streams and logos you own or are licensed to distribute.
- The WebView wrapper does not reuse private T-Play backend credentials or proprietary services.
