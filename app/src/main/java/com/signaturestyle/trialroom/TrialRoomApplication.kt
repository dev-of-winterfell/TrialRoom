package com.signaturestyle.trialroom

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TrialRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Timber for logging (only in debug mode)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Trial Room App Started")
        }

        // Add any other initialization here
        // Example: Analytics, Crash Reporting, etc.
    }
}