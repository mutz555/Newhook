package scope.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.*
import com.highcapable.yukihookapi.hook.param.result
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.type.java.ClassType

@InjectYukiHookWithXposed
class HookEntry : IYukiHookXposedInit {

    override fun onInit() = configs {
        // Konfigurasi YuKiHookAPI jika diperlukan
    }

    override fun onHook() = encase {
        ClassType.load("com.android.server.biometrics.sensors.fingerprint.FingerprintServiceStubImpl").hook {
            method {
                name = "isFpHardwareDetected"
            }.hookAll {
                after {
                    YukiHookAPI.logger.debug("Method isFpHardwareDetected() terpanggil, return akan dipaksa true.")
                    result = true
                }
            }
        }
    }
}