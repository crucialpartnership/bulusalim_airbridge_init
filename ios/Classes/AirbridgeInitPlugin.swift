import Flutter
import UIKit

public class AirbridgeInitPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let instance = AirbridgeInitPlugin()
    registrar.addApplicationDelegate(instance)
  }

  private static func airbridge() -> NSObject.Type? {
    let names = ["AirbridgeFlutter", "airbridge_flutter_sdk.AirbridgeFlutter"]
    for name in names {
      if let cls = NSClassFromString(name) as? NSObject.Type { return cls }
    }
    return nil
  }

  private static func call(_ selectorName: String, _ arg: Any) {
    let sel = NSSelectorFromString(selectorName)
    guard let cls = airbridge(), cls.responds(to: sel) else {
      NSLog("[bulusalim_airbridge_init] AirbridgeFlutter.\(selectorName) not found")
      return
    }
    _ = cls.perform(sel, with: arg)
  }

  public func application(
    _ application: UIApplication,
    open url: URL,
    options: [UIApplication.OpenURLOptionsKey: Any] = [:]
  ) -> Bool {
    AirbridgeInitPlugin.call("trackDeeplinkWithUrl:", url)
    return false
  }

  public func application(
    _ application: UIApplication,
    continue userActivity: NSUserActivity,
    restorationHandler: @escaping ([Any]) -> Void
  ) -> Bool {
    AirbridgeInitPlugin.call("trackDeeplinkWithUserActivity:", userActivity)
    return false
  }
}
