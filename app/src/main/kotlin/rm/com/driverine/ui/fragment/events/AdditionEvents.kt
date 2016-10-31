package rm.com.driverine.ui.fragment.events

import rm.com.driverine.ext.formatAddress
import rm.com.driverine.ext.formatName
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

      it.formatAddress()
    }
  }

val AdditionFragment.onDateSet: (year: Int, monthOfYear: Int, dayOfMonth: Int) -> Unit
  get() = { year, month, day ->

  }
