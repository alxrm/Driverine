package common

import android.graphics.Color

/**
 * Created by alex
 */

val EMPTY_STRING = ""

fun String.asColor(): Int = tryLog { Color.parseColor(this) } ?: Color.BLACK

fun Int.withZeros(count: Int = 2): String = String.format("%0${count}d", this)