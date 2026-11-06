package com.bulusalim.airbridgeinit

import io.flutter.embedding.engine.plugins.FlutterPlugin

/**
 * Empty plugin class. Flutter requires one so the package is treated as an
 * Android plugin (which is what gets its native code and manifest merged).
 * All real work happens in BulusalimApplication.
 */
class AirbridgeInitPlugin : FlutterPlugin {
    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {}
    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {}
}
