package scope.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.factory.hook
import com.highcapable.yukihookapi.hook.factory.hookAll
import com.highcapable.yukihookapi.hook.factory.after
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
                    YukiHookAPI.loggerD("Method isFpHardwareDetected() terpanggil, return akan dipaksa true.")
                    result = true
                }
            }
        }
    }
}