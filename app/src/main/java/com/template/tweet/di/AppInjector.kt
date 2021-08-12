package com.template.tweet.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.template.tweet.CleanApp

/**
 * Helper class to automatically inject fragments if they implement [Injectable].

 */
object AppInjector {

    private var resumed = 0
    private var paused = 0

    fun init(cleanApp: CleanApp) {
        cleanApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                cleanApp.setLocaleContext(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                // Nothing goes here
            }

            override fun onActivityResumed(activity: Activity) {
                ++resumed
                CleanApp.setAppVisible(true)
            }

            override fun onActivityPaused(activity: Activity) {
                ++paused
            }

            override fun onActivityStopped(activity: Activity) {
                CleanApp.setAppVisible(resumed > paused)
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                // Nothing goes here
            }

            override fun onActivityDestroyed(activity: Activity) {
                // Nothing goes here
            }
        })
    }
}
