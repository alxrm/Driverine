package rm.com.driverine.ext

import common.withZeros
import rm.com.driverine.data.model.Citizen
import java.util.*

/**
 * Created by alex
 */

fun formatDateOf(year: Int, month: Int, day: Int): String =
    "${day.withZeros()}.${month.withZeros()}.$year"

fun dateOf(year: Int, month: Int, day: Int): Date =
    Calendar.getInstance().apply { set(year, month, day) }.time

fun Citizen.formatName(): String? =
    if (last.isNullOrBlank() or first.isNullOrBlank() or patronymic.isNullOrBlank())
      null
    else
      "$last ${first?.first()}. ${patronymic?.first()}."

fun Map<String, String>.formatSingle(): String =
    this.values.first()