package jth.com.thetrive.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TheTriveApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}