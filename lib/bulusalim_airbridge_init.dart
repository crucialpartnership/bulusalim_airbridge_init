/// This package has no Dart API.
///
/// Its only job is on Android: it ships a custom Application class
/// (BulusalimApplication) that initializes the Airbridge SDK, and its
/// AndroidManifest registers that class via android:name. The Android
/// manifest merger applies it to the app, because the app's own
/// <application> tag has no android:name.
library bulusalim_airbridge_init;
