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


operator fun Calendar.component1() = get(Calendar.YEAR)
operator fun Calendar.component2() = get(Calendar.MONTH)
operator fun Calendar.component3() = get(Calendar.DAY_OF_MONTH)
operator fun Calendar.component4() = get(Calendar.HOUR_OF_DAY)
operator fun Calendar.component5() = get(Calendar.MINUTE)
