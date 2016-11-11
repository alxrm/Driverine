package common

import java.util.*

/**
 * Created by alex
 */

fun Date?.asCalendar(): Calendar =
    when (this) {
      null -> Calendar.getInstance()
      else -> Calendar.getInstance().apply { time = this@asCalendar }
    }

var Calendar.year: Int
  set(value) = set(Calendar.YEAR, value)
  get() = component1()

var Calendar.month: Int
  set(value) = set(Calendar.MONTH, value)
  get() = component2()

var Calendar.day: Int
  set(value) = set(Calendar.DAY_OF_MONTH, value)
  get() = component3()

var Calendar.hour: Int
  set(value) = set(Calendar.HOUR_OF_DAY, value)
  get() = component4()

var Calendar.minute: Int
  set(value) = set(Calendar.MINUTE, value)
  get() = component5()


operator fun Calendar.component1() = get(Calendar.YEAR)
operator fun Calendar.component2() = get(Calendar.MONTH)
operator fun Calendar.component3() = get(Calendar.DAY_OF_MONTH)
operator fun Calendar.component4() = get(Calendar.HOUR_OF_DAY)
operator fun Calendar.component5() = get(Calendar.MINUTE)
