package com.bulusalim.airbridgeinit

import android.app.Activity
import android.content.Intent
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.PluginRegistry

class AirbridgeInitPlugin : FlutterPlugin, ActivityAware, PluginRegistry.NewIntentListener {
    private var activity: Activity? = null
    private var binding: ActivityPluginBinding? = null

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {}
    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {}

    override fun onAttachedToActivity(binding: ActivityPluginBinding) { attach(binding) }
    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) { attach(binding) }
    override fun onDetachedFromActivityForConfigChanges() { detach() }
    override fun onDetachedFromActivity() { detach() }

    override fun onNewIntent(intent: Intent): Boolean {
        activity?.setIntent(intent)
        return false
    }

    private fun attach(b: ActivityPluginBinding) {
        binding = b
        activity = b.activity
        b.addOnNewIntentListener(this)
    }

    private fun detach() {
        binding?.removeOnNewIntentListener(this)
        binding = null
        activity = null
    }
}
