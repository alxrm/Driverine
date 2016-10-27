package common

import android.os.Looper
import android.os.StrictMode
import rm.com.driverine.BuildConfig

fun assertWorkerThread(): Unit =
		StrictMode.noteSlowCall("slow")

fun isMainThread(): Boolean =
		Looper.myLooper() == Looper.getMainLooper()

fun assertMainThread(): Unit =
		when {
			BuildConfig.DEBUG && !isMainThread() -> error("wrong thread, buddy")
			else                                 -> Unit
		}