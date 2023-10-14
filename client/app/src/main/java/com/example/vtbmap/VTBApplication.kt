package com.example.vtbmap

import android.app.Application
import com.albatros.kplanner.model.module.appModule
import com.yandex.mapkit.MapKitFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class VTBApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("7f658787-bce5-415c-81b0-2ac47bcc7af8")
        val androidContext = this

        val modules = listOf(
            appModule,
        )

        startKoin {
            androidLogger()
            androidContext(androidContext)
            modules(modules)
        }
    }
}