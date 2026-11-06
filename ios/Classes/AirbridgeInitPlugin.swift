import Flutter
import UIKit
import airbridge_flutter_sdk

public class AirbridgeInitPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let instance = AirbridgeInitPlugin()
    registrar.addApplicationDelegate(instance)
  }

  public func application(
    _ application: UIApplication,
    open url: URL,
    options: [UIApplication.OpenURLOptionsKey: Any] = [:]
  ) -> Bool {
    AirbridgeFlutter.trackDeeplink(url: url)
    return false
  }

  public func application(
    _ application: UIApplication,
    continue userActivity: NSUserActivity,
    restorationHandler: @escaping ([Any]) -> Void
  ) -> Bool {
    AirbridgeFlutter.trackDeeplink(userActivity: userActivity)
    return false
  }
}
