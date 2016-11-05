package rm.com.driverine.ext

import common.*
import rm.com.driverine.data.model.Citizen
import java.util.*

/**
 * Created by alex
 */

fun Date.formatDate(): String {
  val (year, month, day) = this.asCalendar()

  return "${day.withZeros()}.${month.withZeros() + 1}.$year"
}

fun dateOf(year: Int, month: Int, day: Int): Date =
    Calendar.getInstance().apply { set(year, month, day) }.time

fun Citizen.formatName(): String? =
    if (last.isNullOrBlank() or first.isNullOrBlank() or patronymic.isNullOrBlank())
      null
    else
      "$last ${first?.first()}. ${patronymic?.first()}."