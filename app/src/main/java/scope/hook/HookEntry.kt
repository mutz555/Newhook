package scope.hook

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.hook
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.log.logger
import com.highcapable.yukihookapi.hook.param.HookParam
import com.highcapable.yukihookapi.hook.type.java.ClassType
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit

@InjectYukiHookWithXposed
class HookEntry : IYukiHookXposedInit {

    override fun onInit() = configs {}

    override fun onHook() = encase {
        ClassType.load("com.android.server.biometrics.sensors.fingerprint.FingerprintServiceStubImpl").hook {
            method {
                name = "isFpHardwareDetected"
            }.hookAll { hookParam: HookParam ->
                hookParam.result = true
                logger.debug("Method isFpHardwareDetected() terpanggil, return akan dipaksa true.")
            }
        }
    }
}