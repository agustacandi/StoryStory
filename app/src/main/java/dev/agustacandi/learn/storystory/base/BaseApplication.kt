package dev.agustacandi.learn.storystory.base

import android.app.Application
import dev.agustacandi.learn.storystory.utils.ConstVal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                ConstVal.koinModules
            )
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}