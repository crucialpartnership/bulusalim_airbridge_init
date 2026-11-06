package com.bulusalim.airbridgeinit

import android.app.Activity
import android.app.Application
import android.os.Bundle
import co.ab180.airbridge.flutter.AirbridgeFlutter
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragmentActivity

class BulusalimApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AirbridgeFlutter.initializeSDK(
            this,
            "bulusalim",
            "8ee9a7afdfea49acaa7fe3d50d502c73"
        )

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityResumed(activity: Activity) {
                if (activity is FlutterActivity || activity is FlutterFragmentActivity) {
                    AirbridgeFlutter.trackDeeplink(activity.intent)
                }
            }
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }
}
