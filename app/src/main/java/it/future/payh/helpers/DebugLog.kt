package it.future.payh.helpers

import android.util.Log
import it.future.payh.BuildConfig

class DebugLog {

    companion object {

        fun d(tag : String, msg : String) {
            if(BuildConfig.DEV)
                Log.d(tag, msg)
        }
    }
}