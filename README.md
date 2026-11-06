# bulusalim_airbridge_init

Initializes the Airbridge SDK on Android from a custom `Application` class, for a FlutterFlow project that can't create native Kotlin files or set `android:name` on `<application>`.

## How it works

- `BulusalimApplication.kt` calls `AirbridgeFlutter.initializeSDK(...)` in `onCreate()`.
- The package's `AndroidManifest.xml` declares `<application android:name="com.bulusalim.airbridgeinit.BulusalimApplication" />`.
- At build time the Android manifest merger combines this with the app manifest. The app's `<application>` has no `android:name`, so this value is used.

iOS is not handled here; it's initialized via FlutterFlow's AppDelegate.swift snippets.

## Requirements

- `airbridge_flutter_sdk` must also be added to the app's dependencies.
- The app's `<application>` tag must not define `android:name`. If another package also ships its own Application class, the build will fail with a manifest merger conflict.

## Changing the token

Edit `android/src/main/java/com/bulusalim/airbridgeinit/BulusalimApplication.kt`, push, then rebuild in FlutterFlow (bump the git ref if you pinned one).
