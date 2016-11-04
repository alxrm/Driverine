package rm.com.driverine.ui.fragment.events

import rm.com.driverine.ext.dateOf
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.constants.*

/**
 * Created by alex
 */

val AdditionFragment.onNameChanged: (inputs: Map<String, String>) -> Unit
  get() = {
    driver.owner?.apply {
      first = it[KEY_INPUT_FIRST_NAME]
      last = it[KEY_INPUT_LAST_NAME]
      patronymic = it[KEY_INPUT_PATRONYMIC]
      save()
    }
  }

val AdditionFragment.onAddressChanged: (inputs: Map<String, String>) -> Unit
  get() = {
    driver.owner?.apply {
      address = it[KEY_INPUT_ADDRESS]
      save()
    }
  }

val AdditionFragment.onDateSet: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit
  get() = { year, month, day ->
    driver.owner?.apply {
      birthDate = dateOf(year, month, day)
      save()
    }
  }

val AdditionFragment.onBrandChange: (Map<String, String>) -> Unit
  get() = {
    driver.car?.apply {
      brand = it[KEY_INPUT_BRAND]
      save()
    }
  }

val AdditionFragment.onColorChange: (Map<String, String>) -> Unit
  get() = {
    driver.car?.apply {
      color = it[KEY_INPUT_COLOR]
      save()
    }
  }

val AdditionFragment.onNumberChange: (Map<String, String>) -> Unit
  get() = {
    driver.car?.apply {
      number = it[KEY_INPUT_NUMBER]
      save()
    }
  }
