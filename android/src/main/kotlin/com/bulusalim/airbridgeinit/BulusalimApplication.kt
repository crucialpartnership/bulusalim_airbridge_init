package com.bulusalim.airbridgeinit

import android.app.Application
import co.ab180.airbridge.flutter.AirbridgeFlutter

class BulusalimApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AirbridgeFlutter.initializeSDK(
            this,
            "bulusalim",
            "8ee9a7afdfea49acaa7fe3d50d502c73"
        )
    }
}
