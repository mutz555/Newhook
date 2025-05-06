package scope.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.type.java.loadClass
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.param.HookParam
import com.highcapable.yukihookapi.hook.factory.hook
import com.highcapable.yukihookapi.hook.factory.hookAll
import com.highcapable.yukihookapi.hook.factory.after
import com.highcapable.yukihookapi.hook.param.result

@InjectYukiHookWithXposed
class HookEntry : IYukiHookXposedInit {

    override fun onInit() = configs {
        // Konfigurasi YuKiHookAPI jika diperlukan
    }

    override fun onHook() = encase {
        loadClass("com.android.server.biometrics.sensors.fingerprint.FingerprintServiceStubImpl").hook {
            method {
                name = "isFpHardwareDetected"
            }.hookAll {
                after {
                    // Log sebelum mengubah hasil return
                    YukiHookAPI.loggerD("Method isFpHardwareDetected() terpanggil, return akan dipaksa true.")
                    result = true
                }
            }
        }
    }
}