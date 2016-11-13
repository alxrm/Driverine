package rm.com.driverine.util.ext

import rm.com.driverine.data.model.Car
import rm.com.driverine.data.model.Citizen
import rm.com.driverine.data.model.Driver

/**
 * Created by alex
 */

fun Driver?.isNotValid() =
    when {
      this == null -> true
      else -> owner.isNotValid() || car.isNotValid()
    }

fun Driver?.isValid(): Boolean = !isNotValid()

fun Citizen?.isNotValid() =
    when {
      this == null -> true
      else -> last.isNullOrBlank()
          || first.isNullOrBlank()
          || patronymic.isNullOrBlank()
          || birthDate == null
    }

fun Car?.isNotValid() =
    when {
      this == null -> true
      else -> brand.isNullOrBlank()
          || color.isNullOrBlank()
          || number.isNullOrBlank()
    }