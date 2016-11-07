package rm.com.driverine.ext

import rm.com.driverine.data.model.Citizen

/**
 * Created by alex
 */

fun Citizen?.isNotValid(): Boolean =
    when {
      this == null -> false
      else -> last.isNullOrBlank()
          || first.isNullOrBlank()
          || patronymic.isNullOrBlank()
          || birthDate == null
    }