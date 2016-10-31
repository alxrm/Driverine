package rm.com.driverine.ext

import common.withZeros
import rm.com.driverine.ui.fragment.constants.KEY_INPUT_ADDRESS
import rm.com.driverine.ui.fragment.constants.KEY_INPUT_FIRST_NAME
import rm.com.driverine.ui.fragment.constants.KEY_INPUT_LAST_NAME
import rm.com.driverine.ui.fragment.constants.KEY_INPUT_PATRONYMIC

/**
 * Created by alex
 */

fun formatDateOf(year: Int, month: Int, day: Int): String =
    "${day.withZeros()}.${month.withZeros()}.$year"

fun Map<String, String>.formatName(): String =
    "${this[KEY_INPUT_LAST_NAME]} ${this[KEY_INPUT_FIRST_NAME]!!.first()}. ${this[KEY_INPUT_PATRONYMIC]!!.first()}."

fun Map<String, String>.formatAddress(): String =
    "${this[KEY_INPUT_ADDRESS]}"

fun Map<String, String>.stubOr(stub: String, action: Map<String, String>.() -> String) =
    when {
      all { it.value.length > 0 } -> action()
      else -> stub
    }