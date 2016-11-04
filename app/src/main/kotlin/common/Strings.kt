package common

import android.graphics.Color

/**
 * Created by alex
 */

val EMPTY = ""

fun String.asColor(): Int = tryLog { Color.parseColor(this) } ?: Color.BLACK

fun String?.orStub(stub: String): String = this ?: stub

fun Int.withZeros(count: Int = 2): String = String.format("%0${count}d", this)