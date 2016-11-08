package common

import android.os.Handler
import android.os.Looper
import android.os.Process
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by alex
 */
val MAIN_THREAD = Handler(Looper.getMainLooper())
val BACKGROUND_THREAD: ExecutorService = Executors.newSingleThreadExecutor { r ->
	object : Thread(r) {
		override fun run() {
			Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT + Process.THREAD_PRIORITY_LESS_FAVORABLE)
			super.run()
		}
	}
}

fun inWorker(task: () -> Unit) {
	BACKGROUND_THREAD.submit { task() }
}

fun inUI(task: () -> Unit) {
	MAIN_THREAD.post { task() }
}

fun inUiDelayed(delay: Long, task: () -> Unit) {
	MAIN_THREAD.postDelayed({ task() }, delay)
}