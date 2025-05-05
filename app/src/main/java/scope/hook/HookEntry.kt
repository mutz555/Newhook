package is.fpbymutz.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import com.highcapable.yukihookapi.YukiHookAPI

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