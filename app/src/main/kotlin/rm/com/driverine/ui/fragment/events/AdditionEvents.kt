package rm.com.driverine.ui.fragment.events

import rm.com.driverine.ext.dateOf
import rm.com.driverine.ext.formatName
import rm.com.driverine.ext.formatSingle
import rm.com.driverine.ext.stubOr
import rm.com.driverine.ui.fragment.AdditionFragment
import rm.com.driverine.ui.fragment.constants.*

/**
 * Created by alex
 */

val AdditionFragment.onNameChanged: (inputs: Map<String, String>) -> String
  get() = {
    it.stubOr(PLACEHOLDER_NAME) {
      driver.owner?.apply {
        first = it[KEY_INPUT_FIRST_NAME]
        last = it[KEY_INPUT_LAST_NAME]
        patronymic = it[KEY_INPUT_PATRONYMIC]
        save()
      }

      it.formatName()
    }
  }

val AdditionFragment.onAddressChanged: (inputs: Map<String, String>) -> String
  get() = {
    it.stubOr(PLACEHOLDER_ADDRESS) {
      driver.owner?.apply {
        address = it[KEY_INPUT_ADDRESS]
        save()
      }

      it.formatSingle()
    }
  }

val AdditionFragment.onDateSet: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit
  get() = { year, month, day ->
    driver.owner?.apply {
      birthDate = dateOf(year, month, day)
      save()
    }
  }

val AdditionFragment.onBrandChange: (Map<String, String>) -> String
  get() = {
    it.stubOr(PLACEHOLDER_BRAND) {
      driver.car?.apply {
        brand = it[KEY_FIELD_BRAND]
        save()
      }

      it.formatSingle()
    }
  }

val AdditionFragment.onColorChange: (Map<String, String>) -> String
  get() = {
    it.stubOr(PLACEHOLDER_COLOR) {
      driver.car?.apply {
        color = it[KEY_FIELD_COLOR]
        save()
      }

      it.formatSingle()
    }
  }

val AdditionFragment.onNumberChange: (Map<String, String>) -> String
  get() = {
    it.stubOr(PLACEHOLDER_NUMBER) {
      driver.car?.apply {
        number = it[KEY_FIELD_NUMBER]
        save()
      }

      it.formatSingle()
    }
  }
