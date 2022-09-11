package com.studies.simpleserviceapplication

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    init {
        instance = this
    }

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntentService", "Service is Running")
                Thread.sleep(1000)
            }
        }catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is Stopping...")
            isRunning = false
            instance.stopSelf()
        }
    }
}
